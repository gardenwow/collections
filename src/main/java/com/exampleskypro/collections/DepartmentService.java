package com.exampleskypro.collections;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(Integer dep) {
        return employeeService.employees.stream().filter(employee -> employee.getDepartment().equals(dep))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee minSalary(Integer dep) {
        return employeeService.employees.stream().filter(employee -> employee.getDepartment().equals(dep))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> allDepartment(Integer dep) {
        return employeeService.employees.stream().filter(e -> e.getDepartment().equals(dep))
                .collect(toList());
    }

    public Map<Integer, List<Employee>> sortDepartment(Integer dep) {
        Map< Integer,List<Employee>> tempEmplList = employeeService.employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return tempEmplList;
    }
}
//Map<Integer, List<Employee>> tempEmplList = employees.stream()
//      .collect(Collectors.groupingBy(Employee::getDepartment));
