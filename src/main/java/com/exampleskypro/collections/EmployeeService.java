package com.exampleskypro.collections;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Petrov", 10001.0, 1),
            new Employee("Oleg", "Krot", 10002.0, 3),
            new Employee("Mariya", "Kostrova", 20003.0, 3),
            new Employee("Nikolai", "Harlamov", 10004.0, 2),
            new Employee("Sergei", "Melden", 10001.0, 2)
    ));


    public Employee addEmployee(String firstName, String lastName, Double salary, Integer department) {
        if (!searchUnicod(firstName, lastName)) {
            throw new BadExep();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName, Double salary, Integer department) {
        if (!searchUnicod(firstName, lastName)) {
            throw new BadExep();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName, Double salary, Integer department) {
        if (!searchUnicod(firstName, lastName)) {
            throw new BadExep();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    private boolean searchUnicod(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }

}