package com.bootcamp.robotikka.robotikkaapi.service.impl;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestUserDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public CommonResponseDTO createUser(RequestUserDTO dto) {
        // generate prefix,
        // generate primary-key
        // send email => (2)
        // save user (not verified)
        return null;
    }
}
