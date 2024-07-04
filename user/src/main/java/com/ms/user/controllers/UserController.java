package com.ms.user.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ms.user.models.UserModel;
import com.ms.user.records.UserRecordDto;

import jakarta.validation.Valid;
import main.java.com.ms.user.services.UserServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyPropoerties(userRecordDto, userModel);
        

        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.save(userModel));

    }


}
