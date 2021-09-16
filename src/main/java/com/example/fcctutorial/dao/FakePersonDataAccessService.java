package com.example.fcctutorial.dao;

import com.example.fcctutorial.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
* Class that implements PersonDao interface, it simulates a DB with the list at line 15
* then every time we invoke the insertPerson method, it will insert a new item on the List
* Notice the @Repository, this let spring boot know we want this class to be instantiated as
* a bean and to be injected in all the classes
* */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList <>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
