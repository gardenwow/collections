package com.exampleskypro.collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmloyeeServiceTestJUnit {

    private final Employee employee1 = new Employee("Lexx", "Luterr", 24000.0, 3);

    private final Employee employee2 = new Employee("Alex", "Manson", 23300.2, 1);
    @Mock
    private EmployeeService employeeService;


    @Test
    public void addEmloyeeTest() {
        Employee employee2 = new Employee("Alex", "Manson", 23300.2, 1);
        employeeService.addEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment());
        //assertThat(employeeService.findEmployee());
//        assertNotNull(employeeService);
        //      employeeService.addEmployee(employee1.getFirstName(),
        //            employee1.getLastName(),
        //          employee1.getSalary(),
        //        employee1.getDepartment());
        //assertEquals(employee1, employeeService.employees.get(employeeService.employees.size() - 1));
        when(employeeService.addEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment())).thenReturn(employee1);
        assertEquals(employee1, employeeService.addEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment()));

        when(employeeService.addEmployee(any(), any(), any(), any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> employeeService.addEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment()));
        verify(employeeService, times(2)).addEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment());

    }

    @Test
    public void deleteEmloyeeTest() {
        when(employeeService.deleteEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment())).thenReturn(employee1);
        assertEquals(employee1, employeeService.deleteEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment()));

        when(employeeService.deleteEmployee(any(), any(), any(), any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> employeeService.deleteEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment()));
        verify(employeeService, times(2)).deleteEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment());

    }
    @Test
    public void findEmloyeeTest() {
        when(employeeService.findEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment())).thenReturn(employee1);
        assertEquals(employee1, employeeService.findEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment()));

        when(employeeService.findEmployee(any(), any(), any(), any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> employeeService.findEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment()));
        verify(employeeService, times(2)).findEmployee(employee1.getFirstName(),
                employee1.getLastName(),
                employee1.getSalary(),
                employee1.getDepartment());

    }


}
