/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.student.dao;
import com.student.beans.StudentBean;
import com.student.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {
static Connection conn;
public int addStudent(StudentBean eb){
conn=ConnectionPool.connectDB();
int r=0;
String sql= "insert into student_data(Enrollment,name,email,p,h,e,m,c,per,status) values('"+eb.getEnrollment()+"','"+eb.getName()+"','"+eb.getEmail()+"','"+eb.getP()+"','"+eb.getH()+"','"+eb.getE()+"','"+eb.getM()+"','"+eb.getC()+"','"+eb.getPer()+"','"+eb.getStatus()+"')";
try {
Statement stmt=conn.createStatement();
r=stmt.executeUpdate(sql);
conn.close();
} catch (SQLException ex) {
Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return r;
}

public int updateStudent(StudentBean eb){
int r=0;
conn=ConnectionPool.connectDB();
String sql= "update student_data set Enrollment='"+eb.getEnrollment()+"', name='"+eb.getName()+"',email='"+eb.getEmail()+"',p='"+eb.getP()+"',h='"+eb.getH()+"',e='"+eb.getE()+"',m='"+eb.getM()+"',c='"+eb.getC()+"',per='"+eb.getPer()+"',status='"+eb.getStatus()+"' where id='"+eb.getId()+"'";
try {
Statement stmt=conn.createStatement();
r=stmt.executeUpdate(sql);
conn.close();
} catch (SQLException ex) {
Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
}

return r;
}


public int deletestudent(int id){
int r=0;
conn=ConnectionPool.connectDB();
String sql="delete from student_data where id='"+id+"'";
try {
Statement stmt=conn.createStatement();
r=stmt.executeUpdate(sql);
conn.close();
} catch (SQLException ex) {
Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return r;
}

public ArrayList<StudentBean> findAll(){
conn=ConnectionPool.connectDB();
String sql="select * from student_data";
ArrayList<StudentBean> al=new ArrayList<StudentBean>();
try {
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next()){
StudentBean x=new StudentBean();
x.setEmail(rs.getString("email"));
x.setEnrollment(rs.getString("Enrollment"));
x.setName(rs.getString("name"));
x.setP(rs.getInt("p"));
x.setH(rs.getInt("h"));
x.setE(rs.getInt("e"));
x.setM(rs.getInt("m"));
x.setC(rs.getInt("c"));
x.setPer(rs.getInt("per"));
x.setStatus(rs.getString("status"));
x.setId(rs.getInt("id"));
al.add(x);
}
conn.close();
} catch (SQLException ex) {
Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
}
return al;
}

public StudentBean findById(int id){
conn=ConnectionPool.connectDB();
StudentBean e=new StudentBean();
String sql="select * from student_data where id='"+id+"'";
try {
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(sql);
if(rs.next()){
e.setEmail(rs.getString("email"));
e.setName(rs.getString("name"));
e.setEnrollment(rs.getString("Enrollment"));
e.setName(rs.getString("name"));
e.setId(rs.getInt("id"));
e.setP(rs.getInt("p"));
e.setH(rs.getInt("h"));
e.setE(rs.getInt("e"));
e.setM(rs.getInt("m"));
e.setC(rs.getInt("c"));
e.setPer(rs.getInt("per"));
e.setStatus(rs.getString("status"));
}
conn.close();
} catch (SQLException ex) {
Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);

}
return e;
}
 


public static void main(String[] args) {
StudentDAO ed=new StudentDAO();
StudentBean e=new StudentBean();


//5. call findById method
e=ed.findById(1);
if(e.getId()>0){
System.out.println(" : "+e.getId()+" : "+e.getName()+" : "+e.getEnrollment()+" : "+e.getEmail()+" : "+e.getP()+" : "+e.getH()+" : "+e.getE()+" : "+e.getM()+" : "+e.getC()+" : "+e.getPer()+" : "+e.getStatus());
}else{
System.out.println("Record not found");
}

//4. call findAll method
// ArrayList<StudentBean>empb=ed.findAll();
// for(StudentBean d:empb){
// System.out.println(" : "+d.getId()+" : "+d.getName()+" : "+d.getEnrollment()+" : "+d.getEmail()+" : "+d.getP()+" : "+d.getH()+" : "+d.getE()+" : "+d.getM()+" : "+d.getC()+" : "+d.getPer()+" : "+d.getStatus());
//
// }

// 3 delete employee

// int r=ed.deletestudent(5);
// if(r>0){
// System.out.println("Data delete success");
// }
// else{
// System.out.println("Data delete not success");
// }




 
//2. call UpdateEmployee()
// e.setEmail("ashu@gmail.com");
// e.setName("Ashu");
// e.setEnrollment("01055");
//  e.setP(80);
//  e.setH(80);
//  e.setE(80);
//  e.setM(80);
//  e.setC(80);
//  e.setPer(80);
//  e.setStatus("PASS");
// 
// e.setId(3);
// int x=ed.updateStudent(e);
// if(x>0){
// System.out.println("Student updated");
// }
// else{
// System.out.println("Student not Updated");
// }
//1. AddEmployee


//e.setEnrollment("0108EE201027");
//e.setName("kk");
//e.setEmail("kk820@gmail.com"); 
//e.setP(90);
//e.setH(90);
//e.setE(80);
//e.setM(91);
//e.setC(75);
//e.setPer(83);
//e.setStatus("PASS");
//int x= ed.addStudent(e);
//if(x>0){
//System.out.println("Data Insert Success");
//}
//else{
//System.out.println("Data Insert failed");
//}
}
}

