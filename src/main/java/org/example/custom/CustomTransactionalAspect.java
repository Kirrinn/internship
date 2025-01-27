package org.example.custom;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.custom.CustomTransactional;
import jakarta.persistence.*;
@Aspect
@Component
public class CustomTransactionalAspect {
//    @Autowired
//    private EntityManager entityManager;


    @Around("@annotation(org.example.custom.CustomTransactional)") // Intercepts methods annotated with @CustomTransactional
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        // Begin custom transaction logic here (e.g., transaction start)
//        EntityTransaction transaction = entityManager.getTransaction();

        System.out.println("Starting custom transaction for method: " + joinPoint.getSignature().getName());

        Object result = null;
        try {
//            transaction.begin();
            //em.persist(customer);
            // Proceed with method execution
            result = joinPoint.proceed();
            // Commit transaction logic here (e.g., if method succeeds)
            System.out.println("Committing transaction for method: " + joinPoint.getSignature().getName());
//            transaction.commit();
        } catch (Throwable throwable) {
            // Rollback logic in case of an exception
//            if (transaction.isActive()) transaction.rollback();
            System.out.println("Rolling back transaction for method: " + joinPoint.getSignature().getName());
            throw throwable;
        }

        return result;
    }

}
