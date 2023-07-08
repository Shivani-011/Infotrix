package com.employee_management;

public interface Employee_Interface {

    //create employee
    public void createEmployee(Employee emp);
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnId(int id);
    //update employee
    public void updateEmployee(int id, String name, double salary, int age, String department);
    //delete employee
    public void deleteEmployee(int id);
}
