package com.exampleskypro.collections;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;
    private Integer department;

    public Double getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public Employee(String firstName, String lastName, Double salary, Integer department) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "имя: " +
                firstName + ", фамилия:  " +
                lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }
}
