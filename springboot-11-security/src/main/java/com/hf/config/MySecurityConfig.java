package com.hf.config;

import com.hf.util.PasswordEncoderUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName: MySecurityConfig
 * @author: xiehongfei
 * @description:
 **/

@EnableWebSecurity // 因为该注解内有Configuration注解，所以无需在这指定@Configuration注解
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 因为父类中有一些特定的规则，所以在这注释掉不用父类的方法
        // super.configure(http);
        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        // 开启自动配置的登陆功能
        http.formLogin();
        // 1、/login来到登录页
        // 2、重定向到/login?error表示登陆失败
        // 3、更多的详细规定
    }

    /**
     * 定制认证规则
     *
     * @param auth
     * @return void
     * @author xiehongfei
     * @date 2021/4/7 22:47
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password(PasswordEncoderUtil.passwordEncoder("123456")).roles("VIP1")
                .and()
                .withUser("lisi").password(PasswordEncoderUtil.passwordEncoder("123456")).roles("VIP2")
                .and()
                .withUser("wangwu").password(PasswordEncoderUtil.passwordEncoder("123456")).roles("VIP3 ");

    }

    /**
     * 绕过静态资源
     *
     * @param web
     * @return void
     * @author xiehongfei
     * @date 2021/4/7 23:04
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
        web.ignoring().antMatchers("/config/**", "/css/**", "/fonts/**", "/img/**", "/js/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 两个等价
        // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }
}
