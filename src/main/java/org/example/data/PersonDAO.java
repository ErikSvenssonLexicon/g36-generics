package org.example.data;

import org.example.model.Person;

import java.util.Collection;

public interface PersonDAO extends BasicDAOCrud<Person, Integer>{

    Collection<Person> findByName(String name);

}
