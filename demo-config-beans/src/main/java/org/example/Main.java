package org.example;


import org.example.configuration.AppConfig;
import org.example.service.ServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
//public class Main implements CommandLineRunner {
//    public static void main(String[] args) {
//
//        SpringApplication.run(Main.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Hello World");
//    }
//}

public class Main{
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceImpl service = ctx.getBean(ServiceImpl.class);
        System.out.println(service);
    }

}