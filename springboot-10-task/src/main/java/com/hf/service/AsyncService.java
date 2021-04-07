package com.hf.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-10-task
 * @description:
 * @author: xiehongfei
 * @create: 2021-04-07 11:58
 **/
@Service
public class AsyncService {

    /**
     * 告诉spring 这是一个异步的任务
     */
    /**
     *
     * @param
     * @return void
     * @author xiehongfei
     * @date 2021/4/7 13:20
     */
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中....");
    }
}
