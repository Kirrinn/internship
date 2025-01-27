package com.example.libraryproject.repository;

import com.example.libraryproject.entity.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest     //kazem da su testovi za jpa podatke da zda da su testovi za podatke
//koristimo ugradjenu test bazu za nase potrebe
//jer ne zelimo da vrsimo testove na pravoj bazi>?????
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PublisherRepositoryTest {

    //bring in the repository
    @Autowired
    private PublisherRepository publisherRepository;

    //we need to bring our publiser
    //all what we do is testing repo methods
    @Test
    void savePublisherTest(){
        //arrange
        Publisher publisher = Publisher.builder()
                .name("Kosta").country("Jamaica").build();
        //assert
        Publisher savedPublisher = publisherRepository.save(publisher);
        //act

        assertNotNull(savedPublisher);
        assertTrue(savedPublisher.getId() > 0);
    }

    @Test
    void findByNameTest() {

        //arrange
        Publisher publisher = new Publisher();
        publisher.setName("Kosta");
        publisherRepository.save(publisher);

        Optional<Publisher> publisherOptional = publisherRepository.findByName(publisher.getName());

        assertTrue(publisherOptional.isPresent());
        assertEquals(publisher.getName(), publisherOptional.get().getName());


    }
}