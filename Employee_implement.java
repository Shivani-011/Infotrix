package com.employee_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee_implement implements Employee_Interface{

    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        
        con=DBConnection.createDBConnection();
        String query="insert into employee values(?,?,?,?,?)";

        try{
            PreparedStatement pstm= con.prepareStatement(query);   //using PreparedStatement because it is a dynamic query
            
            pstm.setInt(1, emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            pstm.setString(5,emp.getDepartment());
            int count= pstm.executeUpdate();
            if(count!=0)
                System.out.println("employee inserted successfully");
                System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnection();
        String query="select * from employee";
        System.out.println("Employee Details");
        System.out.format("%s\t%s\t%s\t\t\t%s\t%s\n","ID","Name","Salary","Age","Department");
        System.out.println("-------------------------------------------------");

        try{
            Statement st=con.createStatement();
            ResultSet result= st.executeQuery(query);

            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4),
                        result.getString(5)
                );
                System.out.println("-------------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        con = DBConnection.createDBConnection();
        String query="select * from employee where id="+id;
        try{
            Statement st=con.createStatement();
            ResultSet result= st.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4),
                        result.getString(5)
                );
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name,double salary, int age,String department) {
        con=DBConnection.createDBConnection();
        String query="update employee set name=?, salary=?, age=?, department=? where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);   //using PreparedStatement because it is a dynamic query

            pstm.setString(1,name);
            pstm.setDouble(2,salary);
            pstm.setInt(3,age);
            pstm.setString(4,department);
            pstm.setInt(5, id);
            int count=pstm.executeUpdate();
            if(count!=0)
                System.out.println("details updated successfully");
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnection();
        String query="delete from employee where id=?";  //using PreparedStatement because it is a dynamic query
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int count=pstm.executeUpdate();
            if(count!=0)
                System.out.println("employee with employee-id "+ id + " deleted successfully!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    
}
