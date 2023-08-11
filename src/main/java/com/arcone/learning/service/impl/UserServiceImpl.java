package com.arcone.learning.service.impl;

import com.arcone.learning.model.UserPO;
import com.arcone.learning.repository.UserRepository;
import com.arcone.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserPO create(UserPO user) {
        return repository.save(user);
    }
}
