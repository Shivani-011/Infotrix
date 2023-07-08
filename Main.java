package com.employee_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name;
        int id;
        Employee_Interface empl=new Employee_implement();
        System.out.println("welcome to Employee Management System \n");

        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("1. Add Employee");
        System.out.println("2. Show All Employees");
        System.out.println("3. Show Employee Based on ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");

        System.out.println("\nEnter your choice");
        int choice=sc.nextInt();

        switch(choice){
            case 1:
                Employee emp=new Employee();

                System.out.println("enter id");
                id=sc.nextInt();

                System.out.println("enter name");
                name=sc.next();

                System.out.println("enter salary");
                double salary=sc.nextInt();
                        
                System.out.println("enter age");
                int age=sc.nextInt();

                System.out.println("enter department");
                String department=sc.next();

                emp.setId(id);
                emp.setName(name);
                emp.setSalary(salary);
                emp.setAge(age);
                emp.setDepartment(department);
            
                empl.createEmployee(emp);
                break;

            case 2:
                empl.showAllEmployee();
                break;

            case 3:
                System.out.println("Enter ID to show the details");
                int empid=sc.nextInt();
                empl.showEmployeeBasedOnId(empid);
                break;

            case 4:
                System.out.println("enter id to update details ");
                id=sc.nextInt();
                System.out.println("enter the new name");
                name=sc.next();
                System.out.println("enter new salary");
                salary=sc.nextInt();
                System.out.println("enter new age");
                age=sc.nextInt();
                System.out.println("enter new department");
                department=sc.next();
                empl.updateEmployee(id, name,salary,age,department);
                break;
            case 5:
                System.out.println("enter id to delete ");
                id=sc.nextInt();
                empl.deleteEmployee(id);
                break;

            case 6:
                System.out.println("Thank for using the Application !");
                System.exit(0);
            default:
                System.out.println("Invalid Choice! \n");

                break;

        }
    }while(true);
    }
}
