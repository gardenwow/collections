package com.exampleskypro.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class ControllerEmployee {
    private final EmployeeService employeeService;

    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello() {
        return "ti zashel v employee add-dobavit, delete-ydalit, find-naiti <br> all world is in u hands  dude";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(name = "firstname") String firstName,
                                @RequestParam(name = "lastname") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam(name = "firstname") String firstName,
                                   @RequestParam(name = "lastname") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.deleteEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(name = "firstname") String firstName,
                                 @RequestParam(name = "lastname") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(employee);

        return employee;
    }

    @GetMapping(path = "/allview")
    public ArrayList<Employee> allView() {
        return employeeService.employees;
    }
}
