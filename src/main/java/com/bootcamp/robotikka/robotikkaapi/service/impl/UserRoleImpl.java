package com.bootcamp.robotikka.robotikkaapi.service.impl;

import com.bootcamp.robotikka.robotikkaapi.entity.UserRole;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRoleRepo;
import com.bootcamp.robotikka.robotikkaapi.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;

    @Autowired
    public UserRoleImpl(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public void initializeRoles() {
        List<UserRole> userRoles = userRoleRepo.findAll();
        if (userRoles.isEmpty()) {
            UserRole role1 = new UserRole("UR-1", "ADMIN",
                    "Super Privileges", null);
            UserRole role2 = new UserRole("UR-2", "MANAGER",
                    "Management Privileges", null);
            UserRole role3 = new UserRole("UR-3", "USER",
                    "regular user", null);

            userRoleRepo.saveAll(List.of(role1,role2,role3));

            // save new user role
        }
    }
}
