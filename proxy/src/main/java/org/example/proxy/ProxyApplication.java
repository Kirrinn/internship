package org.example.proxy;

import jakarta.annotation.Nullable;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootApplication
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }


    //making it more general
    //also I will provide a class and scan for that class if it has a methods that are annotated
    //with CustomTransactional
    //checks if the type we want to inspect has custom annotation on it
    static boolean transactional(Object o) {
        var hasCustomAnotation = new AtomicBoolean(false);

        //todo seeReflectionUtils
        // new ReflectionUtils.MethodCallback()
        //this is on the class but i need it on interfaces because that is how i work
        // so i will have array of classes and i have to loop
        //through every one of them
        var classes = new ArrayList<Class<?>>();
        classes.add(o.getClass());

        Collections.addAll(classes, o.getClass().getInterfaces());
        classes.forEach(clzz ->{
            ReflectionUtils.doWithMethods(clzz, method -> {
                if (method.getAnnotation(CustomTransactional.class) != null || method.getAnnotation(MyAnnotation.class) != null) {
                    hasCustomAnotation.set(true);
                }
            });
        });

        return hasCustomAnotation.get();
    }

    @Bean
    DefaultCustomerService defaultCustomerService() {
        return new DefaultCustomerService();
    }

    @Bean
    MyTransactionalBeanPostProcessor myTransactionalBeanPostProcessor() {
        return new MyTransactionalBeanPostProcessor();
    }

    static class MyTransactionalBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(@Nullable Object target,@Nullable String beanName) throws BeansException {
            assert target != null;
            if (transactional(target)) {
                var pf = new ProxyFactory();
                pf.setInterfaces(target.getClass().getInterfaces());
                pf.setTarget(target);
                //TODO AOP alliance new MethodInterceptor()
                pf.addAdvice((MethodInterceptor) invocation -> {
                    var method = invocation.getMethod();
                    var args1 = invocation.getArguments();


                    try {
                        if (method.getAnnotation(CustomTransactional.class) != null) {
                            System.out.println(method.getName() + "method annotated with @CustomTransactional starts");
                        }
                        if (method.getAnnotation(MyAnnotation.class) != null) {
                            System.out.println(method.getName() + "method annotated with @MyAnnotation starts");
                        }
                        return method.invoke(target, args1);
                    } finally {

                        if (method.getAnnotation(MyAnnotation.class) != null) {
                            System.out.println(method.getName() + "method annotated with @MyAnnotation ends");

                        if (method.getAnnotation(CustomTransactional.class) != null) {
                            System.out.println(method.getName() + "method annotated with @CustomTransactional ends");
                        }
                    }
                    }
                });

                return pf.getProxy(getClass().getClassLoader());

            }
            assert beanName != null;
            return BeanPostProcessor.super.postProcessAfterInitialization(target, beanName);
        }


    }


    @Bean
    ApplicationRunner applicationRunner(CustomerService customerService) {
        return new ApplicationRunner() {

            @Override
            public void run(ApplicationArguments args) throws Exception {
                        //creating a default customer service
                        //var defaultCustomer = new DefaultCustomerService();
//
//
//                        var target = new DefaultCustomerService();
//                        //simplest way to detect custom annotations is using JDK primitive
//                        //TODO
//                        //JDK proxy mechanism
//                        //listener-> it triggers a callback when i call a method on a proxy
////                    var proxyInstance = (customerService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
////                            target.getClass().getInterfaces(), (proxy, method, args1) -> { //InvocationHandler() just replaced with lambda
////                                //proxy object is just implementation
////                                //we want to return invoke of the methode
////                                //we are calling the method on the implementation of the proxy
////                                //wee are calling it in the targeted object but not on the proxy object itself
////                                System.out.println("calling " + method.getName() + " with args " + "["+ args1 +"]");
////                                //we are calling the method on the targeted object
////                               // return method.invoke(target, args);
////
////                                //adding logic for invocation and for search for specific annotation name
////                                try{
////                                    if(method.getAnnotation(CustomTransactional.class)!=null){
////                                        System.out.println(method.getName() + "method annotated with @CustomTransactional starts");
////                                    }
////                                    return method.invoke(target, args1);
////                                }
////                                finally {
////                                    if(method.getAnnotation(CustomTransactional.class)!=null){
////                                        System.out.println(method.getName() + "method annotated with @CustomTransactional ends");
////                                    }
////                                }
////                            });
//
//                        //here i am calling a method of a proxy object that means that this will invoke
//                        //InvocationHandler()
//                        //ability to place ourselves in the call chain as the listener
//                        //simplifying code above because spring have something that is called TODO ProxyFactory
//
//                        //ProxyFactory
//                        var pf = new ProxyFactory();
//                        pf.setInterfaces(target.getClass().getInterfaces());
//                        pf.setTarget(target);
//                        //TODO AOP alliance new MethodInterceptor()
//                        pf.addAdvice((MethodInterceptor) invocation -> {
//                            var method = invocation.getMethod();
//                            var args1 = invocation.getArguments();
//
//                            try {
//                                if (method.getAnnotation(CustomTransactional.class) != null) {
//                                    System.out.println(method.getName() + "method annotated with @CustomTransactional starts");
//                                }
//                                return method.invoke(target, args1);
//                            } finally {
//                                if (method.getAnnotation(CustomTransactional.class) != null) {
//                                    System.out.println(method.getName() + "method annotated with @CustomTransactional ends");
//                                }
//                            }
//                        });
//                        //watch this and this doesn't have a type so i need to downcast it
//                        var proxyInstance = (CustomerService) pf.getProxy(getClass().getClassLoader());
//                        proxyInstance.create();
//                        proxyInstance.add();
//                    }
//
//                };
//            }
                customerService.create();
                customerService.add();
            }
        };
    }
}


//default class for polymorphism that implements interface
class DefaultCustomerService implements CustomerService {

    @Override
    public void create() {
        System.out.println("service()");
    }

    @Override
    public void add() {
        System.out.println("add()");
    }
}

//interface for implementation
interface CustomerService {
    @CustomTransactional
    @MyAnnotation
    void create();

    void add();
}

//adding new behaviour to this class
//adding annotation
//if I want to use it in this file with others I must not declare it as public
//this will do the magic for me before i call create() and then after it
//it will be additional code so now I have to write code for detection of this
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Reflective
@interface CustomTransactional {

}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

}