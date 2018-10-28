package com.junker.api.findpet.service;

import com.junker.api.findpet.domain.User;
import com.junker.api.findpet.repository.UserRepository;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}
