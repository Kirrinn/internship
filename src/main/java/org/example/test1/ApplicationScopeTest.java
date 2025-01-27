package org.example.test1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class ApplicationScopeTest {

    public ApplicationScopeTest() {
        //System.out.println("ApplicationScopeTest as Bean");
    }

    @PostConstruct
    public void init() {
        //System.out.println("ApplicationScopeTest init");
    }


    @PreDestroy
    public void destroy() {
        //System.out.println("ApplicationScopeTest destroy");
    }
}
