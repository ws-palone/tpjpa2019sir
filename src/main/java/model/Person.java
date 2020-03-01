package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    private String mail;
    private String firstName;
    private String lastName;

    private List<Allergy> allergies = new ArrayList<Allergy>();
    private List<Preference> preferences = new ArrayList<Preference>();

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany
    @JoinTable(name = "PERSON_ALLERGY", joinColumns = @JoinColumn(name = "mail"), inverseJoinColumns = @JoinColumn(name = "name"))
    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public void addAllergy(Allergy a) {
        this.allergies.add(a);
    }

    @ManyToMany
    @JoinTable(name = "PERSON_PREFERENCE", joinColumns = @JoinColumn(name = "mail"), inverseJoinColumns = @JoinColumn(name = "name"))
    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public void addPreference(Allergy a) {
        this.allergies.add(a);
    }

}
