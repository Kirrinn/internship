package org.example.configuration;

import org.example.service.ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ServiceImpl myService(){
        return new ServiceImpl();
    }
}
