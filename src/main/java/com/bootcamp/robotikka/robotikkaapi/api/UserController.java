package com.bootcamp.robotikka.robotikkaapi.api;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestUserDTO;
import com.bootcamp.robotikka.robotikkaapi.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping("/visitor/register")//
    public ResponseEntity<StandardResponse>
    createUser(@RequestBody RequestUserDTO dto){
        // save
    }
}
