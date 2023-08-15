package com.arcone.learning.service.impl;

import com.arcone.learning.exception.NotFoundException;
import com.arcone.learning.model.CoursePO;
import com.arcone.learning.model.UserCoursePO;
import com.arcone.learning.model.UserCoursePOId;
import com.arcone.learning.repository.UserCourseRepository;
import com.arcone.learning.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.arcone.learning.model.CourseStatusEnum.IN_PROGRESS;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
public class UserCourseServiceImpl implements UserCourseService {
    private final UserCourseRepository repository;

    @Override
    public List<CoursePO> findAll(String userId, int start, int end) {
        return repository.findAllByIdUserId(userId, of(start, end))
                .map(UserCoursePO::getCourse)
                .getContent();
    }

    @Override
    public void exists(String courseId, String userId) {
        repository.findById(new UserCoursePOId(courseId, userId))
                .map(UserCoursePO::getCourse)
                .filter(course -> IN_PROGRESS.equals(course.getStatus()))
                .orElseThrow(() -> new NotFoundException("There is no valid course assigned"));
    }
}
