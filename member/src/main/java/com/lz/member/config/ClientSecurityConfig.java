package com.lz.member.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 客户端资源安全配置
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@EnableOAuth2Sso
@Configuration
public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable();
    }

}