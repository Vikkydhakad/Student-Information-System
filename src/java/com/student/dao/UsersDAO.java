/*

* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.student.dao;
import com.student.beans.UsersBean;
import com.student.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
* @author Admin
*/
public class UsersDAO {
static Connection conn;
public int registerUser(UsersBean ub){
int r=0;
conn=ConnectionPool.connectDB();
String sql="insert into users(name,username,password) values('"+ub.getName()+"','"+ub.getUserName()+"','"+ub.getPassword()+"')"; 
 
try {
Statement stmt=conn.createStatement();
r=stmt.executeUpdate(sql);
conn.close();
} catch (SQLException ex) {
Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return r;
}
public int loginCheck(String userName,String password){
conn=ConnectionPool.connectDB();
int r=0;
String sql="select uid from users where username='"+userName+"' and password='"+password+"'"; 
 
try {
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(sql);
if(rs.next()){
r=rs.getInt("uid");
}
conn.close();
} catch (SQLException ex) {
Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return r;
}
public static void main(String[] args) {
UsersDAO udao=new UsersDAO();
//Register User Method call

// UsersBean ub=new UsersBean();
// ub.setName("Vikram");
// ub.setUserName("Vikram@123");
// ub.setPassword("12345");
// int r=udao.registerUser(ub);
// if(r>0){
// System.out.println("Registration success");
// }
// else{
// System.out.println("Registration Fail");
// }
//2. Login Check Method call
int x=udao.loginCheck("Vikram@123","12345");
if(x>0){
System.out.println("Login Success");
}
else{
System.out.println("Login Fail");
}
}
}