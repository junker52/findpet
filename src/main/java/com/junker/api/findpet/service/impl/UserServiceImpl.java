package com.junker.api.findpet.service.impl;

import com.junker.api.findpet.domain.User;
import com.junker.api.findpet.repository.UserRepository;
import com.junker.api.findpet.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}
