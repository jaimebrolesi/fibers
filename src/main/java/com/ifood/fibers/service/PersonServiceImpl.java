package com.ifood.fibers.service;

import com.ifood.fibers.domain.Person;
import com.ifood.fibers.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByNameUsingSleep(name);
    }
}
