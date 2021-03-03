package com.hf.demo.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @program: demo
 * @description:给容器中加入我们自己定义的错误属性
 * 响应是自适应的，可以定制ErrorAttributes改变需要返回的内容
 * @author: xiehongfei
 * @create: 2021-03-03 22:02
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("company", "xhfCompany");
        Throwable error = getError(webRequest);
        map.put("error", error);

        //我们的异常处理器所携带的数据
        Map<String, Object> requestAttribute = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", requestAttribute);
        return map;
    }
}
