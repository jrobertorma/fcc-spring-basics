package com.example.fcctutorial.dao;
/*
*  Interfaces let us define the things we can do to the DB and tables associated to
*  the models, we only define methods here
* */

import com.example.fcctutorial.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {
    /*
    * This method inserts a person, it needs an id and a person
    * */
    int insertPerson(UUID id, Person person);

    /*
    * The default method inserts a person without asking for an ID
    * */
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();
}
