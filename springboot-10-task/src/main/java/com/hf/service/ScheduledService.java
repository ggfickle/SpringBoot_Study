package com.hf.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-10-task
 * @description:
 * @author: xiehongfei
 * @create: 2021-04-07 12:53
 **/
@Service
public class ScheduledService {

    /**
     * second,  minute, hour,   day of month（日）,   month,  day of week（周：1-6代表周一到周六，0,7都代表周日，也可写成英语的简写单词）
     * ,    枚举
     * -    区间
     * *    任意
     * /    步长
     * ？   代表解决日期和星期的冲突：比如在日期写*，在星期写2，但是不是每一天都是星期二，所以需要在日期的地方写上？。
     * L    最后
     * W    工作日
     * C    和Calendar联系后计算过的值
     * #    用在星期上，4#2，第2个星期四
     * <p>
     * 【0 0/5 14,18 * * ?】每天的14点和18点整，每隔五分钟启动一次
     * 【0 15 10 ? * 1-6】每个月的周一到周六10点15分执行一次
     * 【0 0 2 ? * 2L】每个月的最后一个周二的两点执行一次
     * 【0 0 2 LW * ?】每个月的最后一个工作日凌晨两点执行一次
     * 【0 0 2-4 ? * 1#1】每个月的第一个周日的两点到4点之间，每个整点都执行一次
     */
//    @Scheduled(cron = "0 * * * * MON-FRI")  指定字符的形式
//    @Scheduled(cron = "0,1,2,3 * * * * MON-Fri")   枚举的形式
//    @Scheduled(cron = "0-10 * * * * mon-fri")   区间的形式
    @Scheduled(cron = "0/5 * 14,18 * * ?")  //从0秒开始每4秒启动一次任务
    public void hello() {
        System.out.println("Task Start...");
    }
}
