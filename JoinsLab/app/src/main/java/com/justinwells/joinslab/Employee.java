package com.justinwells.joinslab;

/**
 * Created by justinwells on 10/28/16.
 */

public class Employee {
    String firstName, lastName, city, ssn;
    int birthYear;

    public Employee(String ssn, String firstName, String lastName, String city, int birthYear) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.birthYear = birthYear;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
