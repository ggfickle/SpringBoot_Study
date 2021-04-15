package com.hf.ticket.service.impl;

import com.hf.api.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TickerServiceImpl
 * @author: xiehongfei
 * @description:
 **/
@Component
@Service (version = "1.0.0" ,interfaceClass = TicketService.class) // 将服务暴露(将服务发送出去)
public class TickerServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
// 注意：@Service注解的import不是平时spring用的那个