package com.bootcamp.robotikka.robotikkaapi.service.impl;


import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


@Repository
public class ApplicationUserDaoImpl implements ApplicationUserDao {
    /*actual database*/

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> findApplicationUserByUsername(String username) {
        return geApplicationUsers().stream().filter(e->e.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> geApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
               new ApplicationUser(
                       USER.getGrantedAuthorities(),
                       "tharaka",
                       passwordEncoder.encode("1234"),
                       true,
                       true,
                       true,
                       true
               ),
               new ApplicationUser(
                       MANAGER.getGrantedAuthorities(),
                       "ayesh",
                       passwordEncoder.encode("1234"),
                       true,
                       true,
                       true,
                       true
               ),
               new ApplicationUser(
                       ADMIN.getGrantedAuthorities(),
                       "nalaka",
                       passwordEncoder.encode("1234"),
                       true,
                       true,
                       true,
                       true
               )
        );
        return applicationUsers;
    }

}
