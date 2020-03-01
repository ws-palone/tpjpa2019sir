package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Meeting {

    public Meeting() {
    }

    private String title;
    private String description;
    private String link;
    private Date date;
    private List<Person>Persons = new ArrayList<Person>();

    @Id
    public String getlink() {
        return link;
    }
    public void setlink(String link) {
        this.link = link;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToMany(mappedBy="meetings")
    public List<Person> getPersons() {
        return Persons;
    }

}