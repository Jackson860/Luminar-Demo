package com.springboot.book;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

	@Autowired
	private DataSource dataSource;

    @Bean
    UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    @Bean
    DaoAuthenticationProvider  authenticationProvider() {
    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    	authProvider.setUserDetailsService(userDetailsService());
    	authProvider.setPasswordEncoder(passwordEncoder());
    	
    	return authProvider;
	}
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.authenticationProvider(authenticationProvider());
    }
    @SuppressWarnings("deprecation")
	protected void configure (HttpSecurity http) throws Exception{
    	http.authorizeRequests()
    		.requestMatchers("/list_users").authenticated()
    		.anyRequest().permitAll()
    		.and()
    		.formLogin()
    			.usernameParameter("email")
    			.defaultSuccessUrl("/list_users")
    			.permitAll()
    		.and()
    		.logout().logoutSuccessUrl("/").permitAll();
    }
	
}
