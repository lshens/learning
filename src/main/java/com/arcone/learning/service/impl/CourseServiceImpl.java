package com.arcone.learning.service.impl;

import com.arcone.learning.exception.ConflictException;
import com.arcone.learning.exception.NotFoundException;
import com.arcone.learning.mapper.CourseMapper;
import com.arcone.learning.model.CoursePO;
import com.arcone.learning.repository.CourseRepository;
import com.arcone.learning.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.arcone.learning.builder.CourseStatusBuilder.builder;
import static com.arcone.learning.model.CourseStatusEnum.EXPIRED;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.data.domain.Sort.by;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private static final int DEFAULT_START = 0;
    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Value("${learning.course.sync.page-size:100}")
    private int sizeSync;
    @Value("${learning.course.months-to-expire:6}")
    private int monthsToExpire;

    @Override
    public CoursePO create(CoursePO course) {
        validate(course);
        return save(course);
    }

    @Override
    public CoursePO update(String id, CoursePO course) {
        validate(course);
        CoursePO po = repository.findById(id).orElseThrow(() -> new NotFoundException("The course does not exist"));
        return save(mapper.merge(course, po));
    }

    @Override
    public List<CoursePO> findAll(int start, int end) {
        return repository.findAll(of(start, end, by("startDate").descending())).getContent();
    }

    @Scheduled(cron = "0 0 1 * * *")
    @Override
    public void sync() {
        sync(of(DEFAULT_START, sizeSync));
    }

    private void sync(Pageable pageable) {
        Page<CoursePO> page = repository.findAllStatusNotEqual(EXPIRED, pageable);
        page.forEach(this::setStatus);
        repository.saveAll(page);
        if (page.hasNext()) {
            sync(page.nextPageable());
        }
    }

    private void validate(CoursePO course) {
        if (repository.existsByName(course.getName())) {
            throw new ConflictException("The course with this name already exists");
        }
    }

    private CoursePO save(CoursePO course) {
        setStatus(course);
        return repository.save(course);
    }

    private void setStatus(CoursePO course) {
        course.setStatus(builder().monthsToExpire(monthsToExpire).start(course.getStartDate()).build());
    }
}
