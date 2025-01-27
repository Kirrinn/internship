package org.example;
//
import org.example.anotations.MovieCatalog;
import org.example.testing.CustomAnotationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class Main implements CommandLineRunner {
//
////    @Autowired
////    private Singleton singleton;
////
////     @Autowired
////     private ApplicationScopeTest applicationScopeTest;
////     @Autowired
////     private Sevis sevis;
//
//
//    @Autowired
//    private MovieCatalog movieCatalog;
//
////    @Autowired
////    @Qualifier("SecondMovieCatalog")
////    private MovieCatalog movieCatalog1;
////
////    @Autowired
////    @Qualifier("SecondMovieCatalog")
////    private MovieCatalog movieCatalog2;
////
////    @Autowired
////    MovieRecommender movieRecommender;

    @Autowired
    CustomAnotationTest customAnotationTest;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        customAnotationTest.performTransactionalOperation();;
    }
}

