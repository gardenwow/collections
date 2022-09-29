package com.exampleskypro.collections;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Lex", "Luter", 54000.0, 2),
            new Employee("Alex", "Manson", 65000.2, 1),
            new Employee("Leonardo", "DeLaKrus",10054.2, 1),
            new Employee("Вася", "Пупкин", 20001.0, 1),
            new Employee("Вася1", "Пупкин2", 200021.0, 2)
    ));

    public Employee addEmployee(String firstName, String lastName, Double salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName, Double salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName, Double salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees) ;
    }

}