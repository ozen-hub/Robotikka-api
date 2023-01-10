package com.bootcamp.robotikka.robotikkaapi.service.impl;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestUserDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRepo;
import com.bootcamp.robotikka.robotikkaapi.service.UserService;
import com.bootcamp.robotikka.robotikkaapi.service.process.EmailService;
import com.bootcamp.robotikka.robotikkaapi.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final Generator generator;
    private final UserRepo userRepo;
    private final EmailService emailService;

    @Autowired
    public UserServiceImpl(Generator generator, UserRepo userRepo, EmailService emailService) {
        this.generator = generator;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @Override
    public CommonResponseDTO createUser(RequestUserDTO dto) {
        String generatedPrefix = generator.generatePrefix(5, 16);
        if (userRepo.findByPrefix(generatedPrefix).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        String primaryKey = generator.generatePrimaryKey(generatedPrefix, "U");
        String verificationCode = generator.createVerificationCode();
        emailService.createEmail(
                dto.getEmail(),
                "Regarding Login",
                "<h1>Verification Code = " + verificationCode + "</h1>"
        );
        return new CommonResponseDTO(200, "Send!", null);
    }
}
