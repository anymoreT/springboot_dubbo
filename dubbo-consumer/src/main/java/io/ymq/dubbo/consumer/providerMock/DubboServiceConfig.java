package io.ymq.dubbo.consumer.providerMock;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

public class DubboServiceConfig {

    public ServiceConfig<GenericService> fillDubboService(MockService mockService, RegistryConfig registryConfig,
                                                          ProtocolConfig protocolConfig, MockGenericService tmpMockservice) {
        ServiceConfig<GenericService> service = new ServiceConfig<GenericService>();
        service.setInterface(mockService.getServiceInterface());
        service.setRef(tmpMockservice); // 指向一个通用服务实现 
        RegistryConfig registry = createRegistry("127.0.0.1", 5000);
        service.setRegistry(registry);
        service.setProtocols(Lists.newArrayList(new ProtocolConfig("dubbo", 8080)));
        if (!StringUtils.isBlank(mockService.getGroupName())) {
            service.setGroup(mockService.getGroupName());
        }
        service.setTimeout(mockService.getTimeout());
        service.setRetries(mockService.getRetries());
        service.setApplication(new ApplicationConfig(mockService.getApplicationName()));
        return service;
    }

    public static RegistryConfig createRegistry(String address, int timeout) {
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress(address);
        registry.setTimeout(timeout);
        return registry;
    }

    public static void regiterDubboServeice(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-test");

        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(8989);

        RegistryConfig registry = createRegistry("127.0.0.1:2181", 50000);
      //  ServiceConfig<GenericService> service = new ServiceConfig<GenericService>();
        ServiceConfig<DubboImplement> service = new ServiceConfig<DubboImplement>();

        service.setApplication(application);
        service.setRegistry(registry);
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
//        Class cls = null;
//        try {
//             cls = Class.forName("hwd.dubbo.tes");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        service.setInterface(DubboInterface.class);
        service.setRef(new DubboImplement());
//        service.setVersion("1.0.0");
        // 暴露及注册服务
        service.export();
        System.out.print("export ok!");
    }
}
