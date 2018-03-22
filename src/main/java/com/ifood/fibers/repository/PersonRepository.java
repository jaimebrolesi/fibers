package com.ifood.fibers.repository;

import com.ifood.fibers.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    // Find foo with 1 second delay
    @Query(value = "SELECT * FROM person, pg_sleep(1) WHERE name = ?1", nativeQuery = true)
    Person findByNameUsingSleep(@Param("name") String name);
}
