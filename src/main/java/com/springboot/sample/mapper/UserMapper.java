package com.springboot.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.sample.entity.User;
import java.util.List;

@Mapper
public interface UserMapper {

    User loadUserByUsername(@Param("username") String username);

    List<User> getAllUsers();
}
