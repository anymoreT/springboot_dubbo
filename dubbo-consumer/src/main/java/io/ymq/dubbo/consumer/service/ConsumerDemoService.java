package io.ymq.dubbo.consumer.service;

import io.ymq.dubbo.api.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: 消费远程方法
 *
 * @author yanpenglei
 * @create 2017-10-27 13:22
 **/
@Service("consumerDemoService")
public class ConsumerDemoService implements DemoService{
    @Autowired
    DemoService demoService;
    public String sayHello(String name) {
        String hello = demoService.sayHello("ben"); // 执行消费远程方法
        System.out.println(hello); // 显示调用结果
        return "{ben}";
    }

}
