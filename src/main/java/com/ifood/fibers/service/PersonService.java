package com.ifood.fibers.service;

import com.ifood.fibers.domain.Person;

public interface PersonService {

    Person findByName(String name);
}
