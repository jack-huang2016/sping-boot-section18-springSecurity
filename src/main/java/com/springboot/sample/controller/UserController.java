package com.springboot.sample.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.sample.entity.User;
import com.springboot.sample.service.UserService;
import com.springboot.sample.utils.SecurityUtils;

/**
 * user表  admin具有所有权限   user具有查看权限不具有操作权限
 */
@Controller
@RequestMapping("/user")
public class UserController {
	 	@Autowired
	    private UserService userService;

	    @RequestMapping(value = "/list")
	    @PreAuthorize("hasAuthority('general_user')")
	    @ResponseBody
	    public List login() {
	       List<User> list =  userService.getAllUsers();
	        return list;
	    }

	    @RequestMapping(value = "/update")
	    @PreAuthorize("hasAuthority('super_admin')")
	    @ResponseBody
	    public HashMap<String, Object> update() {
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("state","success");
	        return map;
	    }


	    @RequestMapping(value = "/del")
	    @PreAuthorize("hasAuthority('super_admin')")
	    @ResponseBody
	    public HashMap<String, Object> del() {
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("state","success");
	        return map;
	    }
	    @RequestMapping(value = "/add")
	    @PreAuthorize("hasAuthority('super_admin')")
	    @ResponseBody
	    public HashMap<String, Object> add() {
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("state","success");
	        return map;
	    }

	    @RequestMapping(value = "/logout")
	    public String logout() {
	        SecurityUtils.logout();
	        return "redirect:login";
	    }

	    @RequestMapping(value = "/info")
	    @ResponseBody
	    public User info() {
	        return SecurityUtils.getUser();
	    }
}
