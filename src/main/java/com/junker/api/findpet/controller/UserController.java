package com.junker.api.findpet.controller;

import com.junker.api.findpet.constants.UrlRoutesConstants;
import com.junker.api.findpet.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlRoutesConstants.API_PREFIX + UrlRoutesConstants.USERS_PREFIX)
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
