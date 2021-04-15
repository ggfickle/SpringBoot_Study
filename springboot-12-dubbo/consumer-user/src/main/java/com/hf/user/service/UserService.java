package com.hf.user.service;
import com.hf.api.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @author: xiehongfei
 * @description:
 **/
@Service
public class UserService {

    // 获取服务
    @Reference(version = "1.0.0")
    private TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到票了:" + ticket);
    }
}
