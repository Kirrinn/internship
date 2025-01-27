package com.example.repository;


import com.example.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    // execute query without jpa entitymanger
    //@Param
    //@Query("select p from Publisher  p where p.name=:name")
    Optional<Publisher> findByName(@Param("name") String name);
}
