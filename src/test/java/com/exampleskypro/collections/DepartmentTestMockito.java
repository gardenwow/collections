package com.exampleskypro.collections;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.assertj.core.api.MapAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.ListAssert;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentTestMockito {

    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach() {
        when(employeeService.findAll()).thenReturn(Arrays.asList(
                new Employee("Ivan", "Petrov", 10001.0, 1),
                new Employee("Oleg", "Krot", 10002.0, 3),
                new Employee("Mariya", "Kostrova", 20003.0, 3),
                new Employee("Nikolai", "Harlamov", 10004.0, 2),
                new Employee("Sergei", "Melden", 10001.0, 2)
        ));

    }

    @ParameterizedTest
    @MethodSource("emplMaxSalaryTestParams")
    public void maxSalaryTest(Integer depart, Employee expected) {
        assertThat(departmentService.maxSalary(depart)).isEqualTo(expected);

    }

    @Test
    public void EmployeesMaxSalaryErrorTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.minSalary(4));
    }

    public static Stream<Arguments> emplMaxSalaryTestParams() {
        return Stream.of(
                Arguments.of(3, new Employee("Mariya", "Kostrova", 20003.0, 3)),
                Arguments.of(2, new Employee("Nikolai", "Harlamov", 10004.0, 2))
        );
    }

    public static Stream<Arguments> emplMinSalaryTestParams() {
        return Stream.of(
                Arguments.of(3, new Employee("Oleg", "Krot", 10002.0, 3)),
                Arguments.of(2, new Employee("Sergei", "Melden", 10001.0, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("emplMinSalaryTestParams")
    public void minSalaryTest(Integer depart, Employee expected) {
        assertThat(departmentService.minSalary(depart)).isEqualTo(expected);

    }

    @Test
    public void EmployeesMinSalaryErrorTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> departmentService.minSalary(4));
    }

    @ParameterizedTest
    @MethodSource("emplDepartTestParams")
    public void departCheckTest(Integer depart, List<Employee> expected) {
        assertThat(departmentService.allDepartment(depart));

    }

    public static Stream<Arguments> emplDepartTestParams() {
        return Stream.of(
                Arguments.of(3, List.of(new Employee("Oleg", "Krot", 10002.0, 3),
                        Arguments.of(2,
                                new Employee("Nikolai", "Harlamov", 10004.0, 2)
                        )

                )));
    }

 /*   @Test
    public void empsDepSortTest() {
        assertThat(departmentService.sortDepartment()).containsExactlyInAnyOrderEntriesOf(Map.of(
                2, List.of(
                        new Employee("Sergei", "Melden", 10001.0, 2),
                        new Employee("Nikolai", "Harlamov", 10004.0, 2)
                ),
                3, List.of(
                        new Employee("Oleg", "Krot", 10002.0, 3),
                        new Employee("Mariya", "Kostrova", 20003.0, 3)
                )
        ));
    }*/
}
