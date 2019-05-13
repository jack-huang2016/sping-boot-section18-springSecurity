package com.springboot.sample.sercurity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springboot.sample.entity.Role;
import com.springboot.sample.entity.User;
import com.springboot.sample.mapper.RoleMapper;
import com.springboot.sample.mapper.UserMapper;

/**
 * 认证和授权
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		//--------------------认证账号
        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }

        List<Role> roles = roleMapper.getRolesByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            //此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
            grantedAuthorities.add(grantedAuthority);
        }
        user.setAuthorities(grantedAuthorities);
        return user;
	}

}
