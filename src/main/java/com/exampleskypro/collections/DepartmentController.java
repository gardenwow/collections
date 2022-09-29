package com.exampleskypro.collections;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/maxsal")
    public Employee maxEmployee(@RequestParam(name = "dep") Integer department){
        return departmentService.maxSalary(department);

    }
    @GetMapping(path = "/minsal")
    public Employee minEmployee(@RequestParam(name = "dep") Integer department){
        return departmentService.minSalary(department);

    }
    @GetMapping(path = "/allDep")
    public List<Employee> allDepEmployee(@RequestParam(name = "dep") Integer department){
        return departmentService.allDepartment(department);

    }
    @GetMapping(path = "/departmentdd")
    public Map<Integer, List<Employee>> depEmployee(@RequestParam(name = "dep") Integer department){
        return departmentService.sortDepartment(department);

    }


    //Map<Integer, List<Employee>> tempEmplList = employees.stream()
      //      .collect(Collectors.groupingBy(Employee::getDepartment));
}
