package com.example.mobileappwsdemo.ui.controller;

import com.example.mobileappwsdemo.service.UserService;
import com.example.mobileappwsdemo.service.impl.UserServiceImpl;
import com.example.mobileappwsdemo.shared.dto.UserDto;
import com.example.mobileappwsdemo.ui.model.request.UserDetailsRequestModel;
import com.example.mobileappwsdemo.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){

        return "user Details";
    }
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, returnValue);

        return returnValue;
    }
    @PutMapping
    public String updateUser(){
        return "user Updated";
    }
    @DeleteMapping
    public String deleteUser(){
        return "user Deleted";
    }
}
