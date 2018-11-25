package io.ymq.config;

import java.util.ArrayList;
import java.util.List;

import io.ymq.providerMock.DubboImplement;
import io.ymq.providerMock.DubboInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;


@Configuration
public class MyDubboConfig {


    //<dubbo:application name="boot-user-service-provider"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("user-service-provider");
        return applicationConfig;
    }

    //<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }
//略

    /**
     *<dubbo:service interface="com.zang.gmall.service.UserService"
     ref="userServiceImpl01" timeout="1000" version="1.0.0">
     <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
     </dubbo:service>
     */
    @Bean
    public ServiceConfig<DubboImplement> userServiceConfig(){
        DubboImplement userService = new DubboImplement();
        ServiceConfig<DubboImplement> serviceConfig = new ServiceConfig<>();
//        serviceConfig.setInterface(DubboInterface.class);
//        serviceConfig.setRef(userService);
//        serviceConfig.setVersion("1.0.0");
//
//        //配置每一个method的信息
//        MethodConfig methodConfig = new MethodConfig();
//        methodConfig.setName("sayHello");
//        methodConfig.setTimeout(1000);
//
//        //将method的设置关联到service配置中
//        List<MethodConfig> methods = new ArrayList<>();
//        methods.add(methodConfig);
//        serviceConfig.setMethods(methods);

        return serviceConfig;
    }

}
