package com.junker.api.findpet.service.impl;

import com.junker.api.findpet.converter.UserConverter;
import com.junker.api.findpet.dto.UserDTO;
import com.junker.api.findpet.repository.UserRepository;
import com.junker.api.findpet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserConverter userConverter;

    @Override
    public List<UserDTO> getAllUsers(){
        return this.userRepository.findAll()
                .stream()
                .map(this.userConverter::userToUserDTO)
                .collect(Collectors.toList());
    }
}
