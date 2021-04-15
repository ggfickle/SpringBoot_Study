package com.hf.providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: TicketService
 * @author: xiehongfei
 * @description:
 **/

@Service
public class TicketService {
    public String getTicket(){
        System.out.println("8003");
        return "《西红柿首富》";
    }
}
