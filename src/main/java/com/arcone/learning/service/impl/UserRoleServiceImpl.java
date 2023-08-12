package com.arcone.learning.service.impl;

import com.arcone.learning.model.UserRolePO;
import com.arcone.learning.model.UserRolePOId;
import com.arcone.learning.repository.UserRoleRepository;
import com.arcone.learning.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private static final String STUDENT_ID = "3de9e5bc-598f-458a-a9a7-0992536ac99f";
    private final UserRoleRepository repository;

    @Override
    public void assignStudent(String userId) {
        repository.save(new UserRolePO(new UserRolePOId(STUDENT_ID, userId)));
    }
}
