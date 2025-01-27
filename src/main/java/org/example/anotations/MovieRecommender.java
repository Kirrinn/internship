package org.example.anotations;

//import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommender {
    private final CustomerPreferenceDao customerPreferenceDao;
    //@Autowired
    //@Inject
    private MovieCatalog movieCatalog;

    //this will provide me all the beans of this type from ApplicationContext
    @Autowired
    private MovieCatalog[] movieCatalogs;

    //@Autowired
//    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao, MovieCatalog movieCatalog) {
//        this.customerPreferenceDao = customerPreferenceDao;
//        this.movieCatalog = movieCatalog;
//    }

    public MovieRecommender(@Qualifier("SecondMovieCatalog") MovieCatalog mc, CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
        this.movieCatalog = mc;

    }
}

//
//Only one constructor of any given bean class may declare @Autowired with
//    the required attribute set to true, indicating the constructor to autowire
//    when used as a Spring bean. As a consequence, if the required attribute is left
//    at its default value true, only a single constructor may be annotated with @Autowired.
//    If multiple constructors declare the annotation, they will all have to declare required=false in
//    order to be considered as candidates for autowiring (analogous to autowire=constructor in XML).
//    The constructor with the greatest number of dependencies that can be satisfied by matching beans in the Spring container
//    will be chosen. If none of the candidates can be satisfied, then a primary/default constructor (if present) will be used.
//    Similarly, if a class declares multiple constructors but none of them is annotated with @Autowired, then a primary/default constructor
//            (if present) will be used. If a class only declares a single constructor to begin with, it will always be used, even if not annotated.
//    Note that an annotated constructor does not have to be public i can see more examples in docs