package com.example.fcctutorial.dao;

import com.example.fcctutorial.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
* Class that implements PersonDao interface (dao/PersonDao.java), also called 'Repository', this
* is part of the 'Data access layer'.
*
* In this case 'FakePersonDataAccessService' simulates a DB with the list at line 23
* then every time we invoke the insertPerson method, it will insert a new item on the List,
* we also can implement every other method from the interface here.
*
* Notice the @Repository annotation, this let spring boot know we want this class to be
* instantiated as a bean and to be injected in all the classes
* */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList <>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if(person.isEmpty()) {
            return 0;
        }
        DB.remove(person.get());
        return 1;
    }

    @Override
    public int updatePersonByID(UUID id, Person updatePerson) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, updatePerson.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
