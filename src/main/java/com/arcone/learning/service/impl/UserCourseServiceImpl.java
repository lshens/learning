package com.arcone.learning.service.impl;

import com.arcone.learning.model.CoursePO;
import com.arcone.learning.repository.UserCourseRepository;
import com.arcone.learning.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
public class UserCourseServiceImpl implements UserCourseService {
    private final UserCourseRepository repository;

    @Override
    public List<CoursePO> findAll(String userId, int start, int end) {
        return repository.findAllByUserId(userId, of(start, end)).getContent();
    }
}
