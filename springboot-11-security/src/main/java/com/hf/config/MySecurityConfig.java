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
        http.formLogin()
                .usernameParameter("user")  //表单用户名name
                .passwordParameter("pwd")   //表单密码name
                .loginPage("/userlogin");   //定制登陆页路径
        // 1、/login来到登录页
        // 2、重定向到/login?error表示登陆失败
        // 3、更多的详细规定
        // 4、默认使用post形式，/Login代表处理登陆，get请求就是去登录页面
        // 5、一旦定制loginPage，那么loginPage的post请求就是处理登陆，get就是去登录页面

        // 开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/"); // 注销成功后来到首页
        // 1、访问/logout，表示用户注销，清空session
        // 2、注销成功会默认返回 /login?logout，使用logoutSuccessUrl可定制注销成功返回页

        //开启记住我
        http.rememberMe().rememberMeParameter("rem");
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie,只要通过检查就可以免登陆，只要点击注销就删除这个cookie
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
