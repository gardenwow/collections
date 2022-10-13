package com.exampleskypro.collections;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class EmloyeeServiceTestJUnit {

    //private final Employee employee1 = new Employee("Lexx", "Luterr", 24000.0, 3);

    //private final Employee employee2 = new Employee("Alex", "Manson", 23300.2, 1);

    private final EmployeeService employeeService = new EmployeeService();


    public Employee addEmloyeeTest() {
        Employee employee2 = new Employee("Alexx", "Mansonn", 2300.2, 1);
        employeeService.addEmployee(employee2.getFirstName(),
                employee2.getLastName(),
                employee2.getSalary(),
                employee2.getDepartment());
        assertThat(employeeService.findAll()).isNotEmpty().containsExactly(employee2);
        assertThat(employeeService.findEmployee(employee2.getFirstName(),
                employee2.getLastName(),
                employee2.getSalary(),
                employee2.getDepartment())).isEqualTo(employee2);

        return employee2;
    }

    @Test
    public void errorMethodAddEmpl() {
        addEmloyeeTest();
    }

    @Test
    public void addEmloyeeErrorTest() {
        Employee employee = addEmloyeeTest();
        assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> employeeService.addEmployee(employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary(),
                        employee.getDepartment()));


    }

    public static Stream<Arguments> addErrorParams() {
        return Stream.of(
                Arguments.of("Alexx", "Mansonn"),
                Arguments.of("Alexx1", "Mansonn", 2300.2, 1),
                Arguments.of("Alexx", "Mansonn2", 2300.2, 1)

        );
    }

    @Test
    public void deleteEmloyeeTest() {

    }

    @Test
    public void findEmloyeeTest() {
        Employee employee4 = new Employee("Ivan", "Petrov", 10001.0, 1);
        assertThat(employeeService.findEmployee(employee4.getFirstName(),
                employee4.getLastName(),
                employee4.getSalary(),
                employee4.getDepartment())).isEqualTo(employee4);

    }
    @Test
    public void findEmloyeeErrorTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class).
                isThrownBy(() -> employeeService.findEmployee("null", "null", null, null));

    }
    @Test
    public void removeEmloyeeTest() {
        Employee employee5 = new Employee("Ivannn", "Petrovvv", 10001.0, 1);
        assertThat(employeeService.deleteEmployee(employee5.getFirstName(),
                employee5.getLastName(),
                employee5.getSalary(),
                employee5.getDepartment())).isEqualTo(employee5);

    }
    @Test
    public void removeEmloyeeErrorTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class).
                isThrownBy(() -> employeeService.deleteEmployee("null", "null", null, null));

    }





}
