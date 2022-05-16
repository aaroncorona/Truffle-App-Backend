package com.example.fansbackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Fan")
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // Mongo ID obj needs to be a string

    private String name;

    private Integer age;

    public Fan() {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Fan(String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters (repo uses them automatically)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }
}
