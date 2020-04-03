package com.appdeveloper.appws.service;

import com.appdeveloper.appws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
}
