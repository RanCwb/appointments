package com.dot.scheduling.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tickets")

public class Ticket implements Serializable {


    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Ticket() {}

    public Ticket(String title, String description, Person person) {
        this.title = title;
        this.description = description;
        this.person = person;
    }

    public Long getId() {
        return id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", person=" + person + "]";
    }
}
