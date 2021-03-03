package com.hf.demo.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @program: springboot-05-EmployeeManagement
 * @description: 国际化配置类
 * @author: xiehongfei
 * @create: 2021-02-16 16:34
 **/
public class MyLocalResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("language");
        Locale requestLocale = httpServletRequest.getLocale();
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            requestLocale = new Locale(split[0], split[1]);
        }
        return requestLocale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
