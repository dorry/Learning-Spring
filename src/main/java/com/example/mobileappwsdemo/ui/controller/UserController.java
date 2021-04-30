package com.example.mobileappwsdemo.ui.controller;

import com.example.mobileappwsdemo.service.UserService;
import com.example.mobileappwsdemo.service.impl.UserServiceImpl;
import com.example.mobileappwsdemo.shared.dto.UserDto;
import com.example.mobileappwsdemo.ui.model.request.UserDetailsRequestModel;
import com.example.mobileappwsdemo.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id){
        UserRest returnValue = new UserRest();

        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);

        return returnValue;
    }
    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
            )
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
