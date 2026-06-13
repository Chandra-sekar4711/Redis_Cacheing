package com.cache.service;

import org.jspecify.annotations.Nullable;

import com.cache.entity.User;

public interface UserService {
    User save(User user);

    @Nullable
    User getUserById(Long id);

    void deleteUserById(Long id);
}
