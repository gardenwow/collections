package com.exampleskypro.collections;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    ArrayList<Employee> employees = new ArrayList<>(List.of(
            new Employee("Lex", "Luter"),
            new Employee("Alex", "Manson"),
            new Employee("Leonardo", "DeLaKrus"),
            new Employee("Вася", "Пупкин")
    ));

    public void addEmployee(Employee employee) {
        if (findEmpl(employee) == true) {
            throw new EmployeeAlreadyAddedException("не возможно добавить сотрудника т.к он уже есть");
        } else employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        if (findEmpl(employee) == false) {
           throw new EmployeeAlreadyAddedException("такого сотрудника нет");
        } else {
            employees.remove(employee);
        }
    }

    public Employee findEmployee(Employee employee) {
        if (findEmpl(employee) == true) {
            throw new EmployeeNotFoundException("такой сутрудник уже есть");
        }
        return employee;
    }

    public boolean findEmpl(Employee employee) {
        for (Employee empls : employees) {
            if (employee.equals(empls)) {
                return true;
            }
        }
        return false;
    }
}