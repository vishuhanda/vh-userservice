package com.vh.hotelapp.userservice.repositories;

import com.vh.hotelapp.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {




}
