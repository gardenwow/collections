package com.exampleskypro.collections;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/list")
public class ControllerEmployee {


    private final EmployeeService employeeService;

    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public String hello() {
        return "ti zashel v employee add-dobavit, delete-ydalit, find-naiti <br> all world is in u hands  dude " +
                " <br> теперь довлена функция осмотра листа";
    }

    @GetMapping("/oddnumber")
    public String oddNumber() {
        return "SetAndMapsService;";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(name = "firstname") String firstName,
                                @RequestParam(name = "lastname") String lastName) {

        return employeeService.addEmployee(firstName, lastName);

    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam(name = "firstname") String firstName,
                                   @RequestParam(name = "lastname") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);

    }

    @GetMapping(path = "/find")
    public Object findEmployee(@RequestParam(name = "firstname") String firstName,
                               @RequestParam(name = "lastname") String lastName) {

        return employeeService.findEmployee(firstName, lastName);

    }

    @GetMapping(path = "/allview")
    public Collection<Employee> allView() {
        return employeeService.findAll();
    }

    @ExceptionHandler
    public String exceptionAdd(EmployeeAlreadyAddedException e) {
        return "даный сотрудник уже есть";
    }

    @ExceptionHandler
    public String exceptionRemove(EmployeeNotFoundException e) {
        return "даного сотрудника нет";
    }
}
