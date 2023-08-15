package com.arcone.learning.service;

import com.arcone.learning.model.UserPO;

public interface UserService {
    UserPO create(UserPO user);

    UserPO update(UserPO user);

    UserPO find(String id);

    String getId(String email);
}
