package com.exampleskypro.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
    public Object addEmployee(@RequestParam(name = "firstname") String firstName,
                                @RequestParam(name = "lastname") String lastName) {
        try{
            return employeeService.addEmployee(firstName,lastName);
        }catch (EmployeeAlreadyAddedException e){
            return "такой сотрудник уже есть";
        }
    }

    @GetMapping(path = "/delete")
    public Object deleteEmployee(@RequestParam(name = "firstname") String firstName,
                                 @RequestParam(name = "lastname") String lastName) {
        try{
            return employeeService.deleteEmployee(firstName, lastName);
        }catch (EmployeeNotFoundException e){

        }
            return "сотрудник не найден";
    }

    @GetMapping(path = "/find")
    public Object findEmployee(@RequestParam(name = "firstname") String firstName,
                                 @RequestParam(name = "lastname") String lastName) {
       try{
           return employeeService.findEmployee(firstName,lastName);
       }catch (EmployeeNotFoundException e){
           return "акой сотрудник не найден";
       }
    }

    @GetMapping(path = "/allview")
    public Collection<Employee> allView() {
        return employeeService.findAll();
    }
}
