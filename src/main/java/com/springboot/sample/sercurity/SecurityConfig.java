package com.springboot.sample.sercurity;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;

@Configuration
@EnableWebSecurity  //启用Web安全功能
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;  //以下方式二：基于数据库的用户存储、认证 才使用
	
    @Autowired
    public void configure(AuthenticationManagerBuilder  auth) throws  Exception{
        //方式一：基于内存的用户存储、认证
       /* auth.inMemoryAuthentication()
                .withUser("admin").password("123456").authorities("super_admin")
                .and()
                .withUser("user").password("654321").authorities("general_user");*/
        
        //方式二：基于数据库的用户存储、认证
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, status from u_md_rs.USER_TEST_TEMP where username = ?")
                .authoritiesByUsernameQuery("select  u.username , r.name from u_md_rs.role_test_temp r, u_md_rs.USER_TEST_TEMP u, u_md_rs.USER_ROLE ur " +  
			"where u.id=ur.user_id and r.id= ur.role_id and u.username=?");*/
        
        //方式三：自定义的用户存储认证
        auth.userDetailsService(customUserDetailsService())
        .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers( "/favicon.ico","/css/**","/common/**","/js/**","/images/**","/login","/userLogin","/login-error").permitAll()
                //所有的访问都需要权限验证，任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                
                /*//登出功能，通过/logout路径可自定义登出的功能
                .and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//注销失败跳转到登录页面
				.logoutSuccessUrl("/login").permitAll()*/
                .and()
                //权限拒绝的页面
                .exceptionHandling().accessDeniedPage("/403")
                //关闭默认的csrf认证
                .and().csrf().disable();
                

        http.logout().logoutSuccessUrl("/login");
    }

    /**
     * 设置用户密码的加密方式
     * @return
     */
    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();

    }

    /**
     * 自定义UserDetailsService，授权
     * @return
     */
    @Bean
    public CustomUserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService();
    }

    /**
     * AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    

}