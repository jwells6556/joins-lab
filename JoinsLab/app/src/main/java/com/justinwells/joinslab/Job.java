package com.justinwells.joinslab;

/**
 * Created by justinwells on 10/28/16.
 */

public class Job {
    int salary, exp;
    String company, ssn;

    public Job(String ssn, int salary, int exp, String company) {
        this.ssn = ssn;
        this.salary = salary;
        this.exp = exp;
        this.company = company;
    }

    public String getSsn() {
        return ssn;
    }

    public int getSalary() {
        return salary;
    }

    public int getExp() {
        return exp;
    }

    public String getCompany() {
        return company;
    }
}
