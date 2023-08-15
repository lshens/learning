package com.arcone.learning.service.impl;

import com.arcone.learning.exception.ConflictException;
import com.arcone.learning.exception.NotFoundException;
import com.arcone.learning.model.UserPO;
import com.arcone.learning.repository.UserRepository;
import com.arcone.learning.service.UserRoleService;
import com.arcone.learning.service.UserService;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import liquibase.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static liquibase.repackaged.org.apache.commons.lang3.StringUtils.EMPTY;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserRoleService userRoleService;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserPO create(UserPO user) {
        validate(user);
        user.setSecret(encoder.encode(user.getSecret()));
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

    @Override
    public String getId(String email) {
        return repository.findByEmail(email).map(UserPO::getId).orElseGet(() -> EMPTY);
    }

    private void validate(UserPO user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ConflictException("The user already exists");
        }
    }
}
