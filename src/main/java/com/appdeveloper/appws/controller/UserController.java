package com.appdeveloper.appws.controller;

import com.appdeveloper.appws.model.request.UserDetailsRequestModel;
import com.appdeveloper.appws.model.response.UserRest;
import com.appdeveloper.appws.service.UserService;
import com.appdeveloper.appws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "users" ) // http://localhost:8080/users
public class UserController {

    // This is a basic restful web services defines CRUD operation.


    UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }


    @DeleteMapping
    public String deleteUser() { return "delete user was called";
    }


}
