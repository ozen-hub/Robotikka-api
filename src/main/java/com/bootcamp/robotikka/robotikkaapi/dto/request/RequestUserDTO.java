package com.bootcamp.robotikka.robotikkaapi.dto.request;

import com.bootcamp.robotikka.robotikkaapi.entity.LovedProperty;
import com.bootcamp.robotikka.robotikkaapi.entity.Orders;
import com.bootcamp.robotikka.robotikkaapi.entity.UserRole;
import com.bootcamp.robotikka.robotikkaapi.entity.share.FileResource;
import com.bootcamp.robotikka.robotikkaapi.entity.share.UserNameResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDTO {
    private String contactNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
