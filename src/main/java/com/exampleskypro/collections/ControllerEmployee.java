package com.exampleskypro.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Stream;

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
                                @RequestParam(name = "lastname") String lastName,
                                @RequestParam(name = "salary") Double salary,
                                @RequestParam(name = "dep") int department) {

        return employeeService.addEmployee(firstName, lastName, salary, department);

    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam(name = "firstname") String firstName,
                                   @RequestParam(name = "lastname") String lastName,
                                   @RequestParam(name = "salary") Double salary,
                                   @RequestParam(name = "dep") int department) {

        return employeeService.deleteEmployee(firstName, lastName, salary, department);

    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(name = "firstname") String firstName,
                                 @RequestParam(name = "lastname") String lastName,
                                 @RequestParam(name = "salary") Double salary,
                                 @RequestParam(name = "dep") int department) {
        return employeeService.findEmployee(firstName, lastName, salary, department);

    }

    @GetMapping(path = "/allview")
    public Collection<Employee> allView() {
        return employeeService.findAll();
    }


}
