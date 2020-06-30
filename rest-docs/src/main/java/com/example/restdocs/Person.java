package com.example.restdocs;

/**
 * Author: Rustambekov Avazbek
 * Date: 05/05/2020
 * Time: 13:13
 */
public class Person {

    private long id;
    private String fullName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Person(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

}
