package com.vh.hotelapp.userservice.impl;

import com.vh.hotelapp.userservice.Exceptions.ResourceNotFoundException;
import com.vh.hotelapp.userservice.entities.User;
import com.vh.hotelapp.userservice.repositories.UserRepository;
import com.vh.hotelapp.userservice.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUser_id(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String user_id) {
        User user =  userRepository.findById(user_id)
                             .orElseThrow(() -> new ResourceNotFoundException("User Not found with user id " + user_id));

        ArrayList arrayList = restTemplate.getForObject("http://localhost:8084/ratings/users/2a749318-ee68-4b24-aec2-1eba7b64fb3c",ArrayList.class);
//        logger.info("---- "+ arrayList);
        System.out.println("---- " + arrayList);
        return user;

    }
}
