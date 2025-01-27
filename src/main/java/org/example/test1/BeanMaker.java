package org.example.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanMaker {

    @Autowired
    private Repo  repo;

    @Bean
    public Sevis serviceMaker(){
        return new Sevis(repo);
    }
}
