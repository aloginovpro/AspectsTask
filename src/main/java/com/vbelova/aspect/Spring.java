package com.vbelova.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Spring {

    @Bean
    public ElectionService electionService() {
        return new ElectionServiceImpl();
    }

    @Bean
    public Aspect aspect() {
        return new Aspect();
    }

}
