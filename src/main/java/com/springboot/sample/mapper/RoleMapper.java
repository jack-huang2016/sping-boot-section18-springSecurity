package com.springboot.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.springboot.sample.entity.Role;

@Mapper
public interface RoleMapper {
	
	List<Role> getRolesByUserId(int id);
}
