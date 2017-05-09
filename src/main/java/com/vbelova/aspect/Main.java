package com.vbelova.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext appContext;
        appContext = new ClassPathXmlApplicationContext("spring.xml");
//        appContext = new AnnotationConfigApplicationContext(Spring.class);

        ElectionService someService = appContext.getBean(ElectionService.class);
        someService.vote("Marcon");
    }

}
