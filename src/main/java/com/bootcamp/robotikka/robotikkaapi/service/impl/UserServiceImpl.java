package com.bootcamp.robotikka.robotikkaapi.service.impl;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestUserDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRepo;
import com.bootcamp.robotikka.robotikkaapi.service.UserService;
import com.bootcamp.robotikka.robotikkaapi.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserServiceImpl implements UserService {

    private final Generator generator;
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(Generator generator, UserRepo userRepo) {
        this.generator = generator;
        this.userRepo = userRepo;
    }

    @Override
    public CommonResponseDTO createUser(RequestUserDTO dto) {
        String generatedPrefix = generator.generatePrefix(5, 16);
        if (userRepo.findByPrefix(generatedPrefix).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        //==>
        // generate primary-key
        // send email => (2)
        // save user (not verified)
        return null;
    }
}
