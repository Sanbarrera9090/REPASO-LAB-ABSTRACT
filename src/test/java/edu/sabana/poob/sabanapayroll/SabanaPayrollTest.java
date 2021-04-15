package edu.sabana.poob.sabanapayroll;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SabanaPayrollTest {
    public static SabanaPayroll sp1 = new SabanaPayroll();
    public static Department d1 = new Department("FINANZAS", UUID.randomUUID());
    public static Department d2 = new Department("VENTAS", UUID.randomUUID());
    public static Department d3 = new Department("INGENIERIA", UUID.randomUUID());
    public static EmployeeByComission c1 = new EmployeeByComission("Juan", "Perez", d1, 1);
    ;
    public static EmployeeByHours h1 = new EmployeeByHours("Jorge", "Gomez", d2, 5);
    public static EmployeeBySalary s1 = new EmployeeBySalary("Laura", "Beltran", d3, 1);
    public List<Department> departments = new ArrayList<>();
    public List<Employee> employees = new ArrayList<>();


    @Test
    @DisplayName("GIVEN the ID of an employee by salary WHEN trying to calculate his salary THEN should calculate it")
    public void shouldCalculateEmployeeSalaryBySalary() {
        assertTrue(Double.compare(1.20, d1.calculateSalary()) == 0);
    }

    @Test
    public void shouldCalculateEmployeeSalaryByHours() {
        assertTrue(Double.compare(15, h1.calculateSalary()) == 0);
    }

    @Test
    public void shouldCalculateEmployeeSalaryByComission() {
        assertEquals(0, Double.compare(2, c1.calculateSalary()));
    }

    @Test
    public void shouldCalculateEmployeeBalance() {
        SabanaPayroll sa1 = new SabanaPayroll();
        BankAccount b1;
        Checking c1 = new Checking();
        Savings s1 = new Savings();
        Department d1 = new Department("Centro", UUID.randomUUID());
        EmployeeBySalary e1 = new EmployeeBySalary("santiago", "Barrera", d1, 10, c1 = new Checking());
        EmployeeByHours e2 = new EmployeeByHours("Uribe", "Paraco", d1, 10, s1);
        departments.add(d1);
        employees.add(e1);
        employees.add(e2);
        d1.setEmployees(employees);
        sa1.setDepartments(departments);

        c1.deposit(10000);
        Assertions.assertEquals(5000, sa1.calculateEmployeeBalance(e1.getId()));

        s1.deposit(10000);
        Assertions.assertEquals(8000, sa1.calculateEmployeeBalance(e2.getId()));
    }

    @Test
    public void shouldDepositToEmployee() {
        SabanaPayroll sa1 = new SabanaPayroll();
        BankAccount b1;
        Checking c1 = new Checking();
        Savings s1 = new Savings();
        Department d1 = new Department("Derecha", UUID.randomUUID());
        EmployeeBySalary e1 = new EmployeeBySalary("santiago", "Barrera", d1, 10, c1 = new Checking());
        EmployeeByHours e2 = new EmployeeByHours("Uribe", "Paraco", d1, 10, s1);
        departments.add(d1);
        employees.add(e1);
        employees.add(e2);
        d1.setEmployees(employees);
        sa1.setDepartments(departments);

        assertTrue(sa1.depositToEmployee(e1.getId(), 6000));
        assertTrue(sa1.depositToEmployee(e2.getId(), 3000));
    }

    @Test
    public void shouldCalculateAllEmployeesBalance() {
        SabanaPayroll sa1 = new SabanaPayroll();
        BankAccount b1;
        Checking c1 = new Checking();
        Savings s1 = new Savings();
        Department d1 = new Department("Izquierda", UUID.randomUUID());
        EmployeeBySalary e1 = new EmployeeBySalary("santiago", "Barrera", d1, 10, c1 = new Checking());
        EmployeeByHours e2 = new EmployeeByHours("Uribe", "Paraco", d1, 10, s1);
        departments.add(d1);
        employees.add(e1);
        employees.add(e2);
        d1.setEmployees(employees);
        sa1.setDepartments(departments);
        c1.deposit(10000);
        s1.deposit(10000);

        Assertions.assertEquals(13000, sa1.calculateAllEmployeeBalance());


    }
}