package com.example.fcctutorial.service;

import com.example.fcctutorial.dao.PersonDao;
import com.example.fcctutorial.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* In the service layer we can define business logic, for now we are
* creating a reference to the Data access layer, and create the methods
* we will be able to call from the API/controller layer.
* Notice the @Service line, this lets spring boot to know this is a service
* and allows the class to use 'dependency injection'
* */
@Service
public class PersonService {
    //reference to Data access layer
    private final PersonDao personDao;

    /*
    * We use @Autowired to make the 'dependency injection'
    * since we can have multiple implementations of the interface
    * we must differentiate them with @Qualifier, this value must be the same
    * defined at the interface implementation (at /dao/FakePersonDataAccessService.java)
    * */
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    //methods available to the API, these are defined at dao/PersonDao.java
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }
}
