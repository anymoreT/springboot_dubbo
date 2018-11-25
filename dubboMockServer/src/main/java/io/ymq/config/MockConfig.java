package io.ymq.config;

import io.ymq.providerMock.DubboServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockConfig {
    @Bean
    DubboServiceConfig mockDubbo(){
        DubboServiceConfig dubboServiceConfig =  new DubboServiceConfig();
        dubboServiceConfig.regiterDubboServeice();
        return dubboServiceConfig;
    }
}
