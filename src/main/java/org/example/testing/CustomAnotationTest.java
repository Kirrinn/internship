package org.example.testing;

import org.example.custom.CustomTransactional;
import org.springframework.stereotype.Component;

@Component
public class CustomAnotationTest {

    @CustomTransactional  // Apply the custom annotation
    public void performTransactionalOperation() {
        System.out.println("Executing transactional operation...");

    }

}