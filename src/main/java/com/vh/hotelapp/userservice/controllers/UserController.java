package com.vh.hotelapp.userservice.controllers;


import com.vh.hotelapp.userservice.entities.User;
import com.vh.hotelapp.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
            User createuser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createuser);
    }

    @GetMapping("/{user_Id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String user_Id){
        User user = userService.getUser(user_Id);
        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }


}
