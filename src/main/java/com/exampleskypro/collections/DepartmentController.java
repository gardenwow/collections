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
    @GetMapping(path = "allDep", params = "department")
    public List<Employee> allDepEmployee(@RequestParam(name = "department") Integer department){
        return departmentService.allDepartment(department);

    }
    @GetMapping(path = "allDep")
    public Map<Integer, List<Employee>> depEmployee(){
        return departmentService.sortDepartment();

    }
}
