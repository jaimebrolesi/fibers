package com.ifood.fibers.bootstrap;

import com.ifood.fibers.domain.Person;
import com.ifood.fibers.repository.PersonRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ProjectBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PersonRepository personRepository;

    public ProjectBootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Person person = new Person("foo");
        personRepository.save(person);
    }
}
