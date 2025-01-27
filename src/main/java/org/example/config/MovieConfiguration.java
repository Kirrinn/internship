package org.example.config;

import org.example.anotations.MovieCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MovieConfiguration {


    //if i have multiple movies catalogs as beans this will be autowiring candidate
    //because i put promary annotation on it so that proxy will know taht this one have advantage
    @Bean
    @Primary
    public MovieCatalog firstMovieCatalog() {
        //System.out.println("firstMovieCatalog");
        return new MovieCatalog();
    }

    @Bean(name = "SecondMovieCatalog")
    public MovieCatalog secondMovieCatalog() {
        //System.out.println("secondMovieCatalog");
        return new MovieCatalog();
    }
}
