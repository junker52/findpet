package com.junker.api.findpet.service;

import com.junker.api.findpet.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
}
