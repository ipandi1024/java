package com.woniu.eureka;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @className:ConfigAdapter
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/22 10:42
 * @Version:1.0
 **/
@EnableWebSecurity
public class ConfigAdapter extends WebSecurityConfigurerAdapter {
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
