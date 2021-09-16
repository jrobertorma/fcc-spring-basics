package com.example.fcctutorial.api;

import com.example.fcctutorial.model.Person;
import com.example.fcctutorial.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Controllers are the API layer that has interaction with the user, we use
* references to the models and the service layer to interact with the DB through
* all the other components. We use @RestController to let spring boot know this is a controller
* @RequestMapping is used to define the endpoint of the controller
* */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    //reference to the service
    private final PersonService personService;

    /*
    * We also need to use @Autowired here, to be able to use PersonService
    * */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*
    * Method to insert new person, this method will be interacting with the client, so
    * it may be called with a POST request, to enable that we use @PostMapping.
    * With @RequestBody we are saying that we want to take the request body and shovel
    * that inside of the person argument
    * */
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    /*
    * We call a new method defined at the service layer to get all the Persons stored,
    * notice we use @GetMapping, this way when the request goes to the same endpoint
    * but with a GET header, this method will be called
    * */
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
}
