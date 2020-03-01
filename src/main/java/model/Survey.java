package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Survey {

    private String lien;
    private List<Meeting>meetings = new ArrayList<Meeting>();
    private List<Person>persons = new ArrayList<Person>();

    @Id
    public String getLien() {
        return lien;
    }
    public void setLien(String lien) {
        this.lien = lien;
    }

    @OneToMany
    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeeting(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void addMeeting(Meeting meeting){
        this.meetings.add(meeting);
    }

    @ManyToMany(mappedBy="surveys")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> Persons) {
        this.persons = Persons;
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }

}
