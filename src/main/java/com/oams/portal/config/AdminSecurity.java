package com.oams.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(3)
public class AdminSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String password = passwordEncoder.encode("password");
        auth.inMemoryAuthentication()
                .withUser("kavin")
                .password(password)
                .roles("admin").authorities("admin");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**")
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/admin/main-page")
                .and()
                .logout()
                .logoutSuccessUrl("/home");

    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/student/form"
                ,"/student/register",
                "/h2-console/**",
                "/downloadFile/*",
                "/h2-console/**"
                ,"/uploads/**",
                "/resources/**",
                "/webjars/**");
    }
}
