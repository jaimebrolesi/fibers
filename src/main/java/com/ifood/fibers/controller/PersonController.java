package com.ifood.fibers.controller;

import co.paralleluniverse.fibers.SuspendExecution;
import com.ifood.fibers.domain.Person;
import com.ifood.fibers.service.PersonService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fiber")
    //using throws instead annotation @Suspendable.
    public Person usingFiber(@PathVariable String name) throws InterruptedException, SuspendExecution {
        return personService.findByName("foo");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nfiber")
    public Person usingJPAOnly() {
        return personService.findByName("foo");
    }
}
