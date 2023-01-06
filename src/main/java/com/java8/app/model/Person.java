package com.java8.app.model;

import java.time.ZonedDateTime;

public class Person {
    public enum Gender { MALE, FEMALE }
    private final String firstName;
    private final String lastName;
    private final ZonedDateTime birth;
    private final Gender gender;

    public Person(String firstName, String lastName, ZonedDateTime birth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
    }

    public void test(){

    }
}
