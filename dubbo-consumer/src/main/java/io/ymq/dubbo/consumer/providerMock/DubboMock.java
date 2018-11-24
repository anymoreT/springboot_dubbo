package io.ymq.dubbo.consumer.providerMock;

import com.alibaba.dubbo.config.ReferenceConfig;
public class DubboMock {
    int  serviceId  = 1;
    ProtocolConfig  protocolConfig;
    RegistryConfig registryConfig;
    String registryAddress = "127.0.0.1:2181";

    public void init() {
        protocolConfig = new ProtocolConfig();
        registryConfig = new RegistryConfig();
        mockProtocolConfig();
        mockRegistryConfig();
        mockServiceMethodRule();
        mockService();
    }

    private void mockProtocolConfig() {
        protocolConfig.setId(serviceId);
        protocolConfig.setProtocolName("dubbo");
        protocolConfig.setProtocolPort(18878);

    }

    private void mockRegistryConfig() {
//        registryConfigMapper = mock(RegistryConfigMapper.class);
//        registryConfig.setId(serviceId);
        registryConfig.setRegistryAddress(registryAddress);
        registryConfig.setRegistryProtocol("zookeeper");
        registryConfig.setRegistryTimeout(50000);
//        when(registryConfigMapper.selectByPrimaryKey(serviceId)).thenReturn(registryConfig);
//        ReflectionTestUtils.setField(dubboMockServer, "registryConfigMapper", registryConfigMapper);
    }
    private void mockServiceMethodRule() {
        ServiceMethedRule smr = new ServiceMethedRule();
        smr.setId(8);
        smr.setServiceId(serviceId);
        smr.setMethodName("getList");
        smr.setWhenScript("arg.name=='xxx'");
        smr.setReturnMessage("[{'name':'zxc','age':11,class:'com.tony.test.protocol.Par'}]");
    }

    private MockService mockService() {
        MockService mockService = new MockService();
        mockService.setApplicationName("xx");
        mockService.setTimeout(5000000);
        mockService.setRetries(0);
        mockService.setId(serviceId);
        mockService.setProtocolId(serviceId);
        mockService.setRegistryId(serviceId);
        mockService.setServiceInterface("com.tony.test.protocol.TestAbcService");
        mockService.setServiceStatus("start");
//        when(mockServiceMapper.selectByPrimaryKey(serviceId)).thenReturn(mockService);
//        ReflectionTestUtils.setField(dubboMockServer, "mockServiceMapper", mockServiceMapper);
        return mockService;
    }

}
