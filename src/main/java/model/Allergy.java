package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Allergy {

    @Id
    private String name;
    private List<Person> persons = new ArrayList<Person>();

    public Allergy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy="allergies")
    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person p) {
        this.persons.add(p);
    }


}