package org.example.test1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Singleton {



    //Zasto mi dva puta napravi, da nije kao aha kada punim klasu jer je staticka metoda sa njom u memoriji
    //i posle kada je napravim samu od sebee;
    //Mogu da bih napravio bean od ovog
    @Bean
    public static ApplicationScopeTest ApplicationScopeTestAsBeanFromSingleton() {
        return new ApplicationScopeTest();
    }

    @PostConstruct
    public void init() {
        //System.out.println("Singleton init");
    }


    @PreDestroy
    public void destroy() {
        //System.out.println("Singleton destroy");
    }
}
