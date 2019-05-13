package com.springboot.sample.service;

import java.util.List;
import com.springboot.sample.entity.User;

public interface UserService{

    User loadUserByUsername(String s);

    List<User> getAllUsers();

}
