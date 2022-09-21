package com.exampleskypro.collections;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    ArrayList<Employee> employees = new ArrayList<>(List.of(
            new Employee("Lex", "Luter"),
            new Employee("Alex", "Manson"),
            new Employee("Leonardo", "DeLaKrus"),
            new Employee("Вася", "Пупкин")
    ));

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees) ;
    }
}