package com.springboot.sample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.sample.entity.User;
import com.springboot.sample.mapper.UserMapper;
import com.springboot.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String s) {
        return userMapper.loadUserByUsername(s);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
