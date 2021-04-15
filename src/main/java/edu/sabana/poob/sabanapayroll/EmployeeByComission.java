package edu.sabana.poob.sabanapayroll;

import java.util.UUID;

public class EmployeeByComission extends Employee {
    public static final double COMISSION = 2;
    private int trabajo;
    public EmployeeByComission(String name, String lastName, Department department, int trabajo) {
        super(name, lastName, department);
        this.trabajo=trabajo;
    }
    public EmployeeByComission(String name, String lastName, Department department, int trabajo, BankAccount account) {
        super(name, lastName, department,account);
        this.trabajo=trabajo;
    }
    @Override
    public double calculateSalary()
    {
        return this.trabajo*COMISSION;
    }
    
    @Override
    public String toString() {
        
        return String.format("%s %s, departamento %s, ", this.name, this.lastName, this.department.getName() )+String.format(" salario %s $, pago por comision", this.calculateSalary());
    }
}
