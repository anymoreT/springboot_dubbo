package io.ymq.dubbo.consumer.service;

import io.ymq.dubbo.api.DemoService;

import io.ymq.providerMock.DubboInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: 消费远程方法
 *
 * @author yanpenglei
 * @create 2017-10-27 13:22
 **/
@Service("consumerDemoService")
public class ConsumerDemoService {

    @Autowired
    private DubboInterface demoService;

    public void sayHello(String name) {
        String hello = demoService.sayHello(); // 执行消费远程方法
        System.out.println(hello); // 显示调用结果
    }

}
