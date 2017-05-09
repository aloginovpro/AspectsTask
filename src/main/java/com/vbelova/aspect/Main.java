package com.vbelova.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        ElectionService someService = appContext.getBean(ElectionService.class);
        someService.vote("Marcon");
    }

}
