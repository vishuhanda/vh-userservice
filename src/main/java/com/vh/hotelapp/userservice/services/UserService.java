package com.vh.hotelapp.userservice.services;

import com.vh.hotelapp.userservice.entities.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);


    List<User> getAllUser();


    User getUser(String user_id);


}
