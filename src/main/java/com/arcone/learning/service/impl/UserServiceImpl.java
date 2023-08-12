package com.arcone.learning.service.impl;

import com.arcone.learning.exception.ConflictException;
import com.arcone.learning.exception.NotFoundException;
import com.arcone.learning.model.UserPO;
import com.arcone.learning.repository.UserRepository;
import com.arcone.learning.service.UserRoleService;
import com.arcone.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserRoleService userRoleService;

    @Override
    public UserPO create(UserPO user) {
        validate(user);
        UserPO userPO = repository.save(user);
        userRoleService.assignStudent(userPO.getId());
        return userPO;
    }

    @Override
    public UserPO update(UserPO user) {
        return repository.save(user);
    }

    @Override
    public UserPO find(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("The user does not exist"));
    }

    private void validate(UserPO user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ConflictException("The user already exists");
        }
    }
}
