package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Preference {

    @Id
    private String name;
    private List<Person> persons = new ArrayList<Person>();

    public Preference() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy="preferences")
    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person p) {
        this.persons.add(p);
    }

}