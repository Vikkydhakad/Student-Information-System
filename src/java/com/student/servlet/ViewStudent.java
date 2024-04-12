/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.servlet;

import com.student.beans.StudentBean;
import com.student.dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class ViewStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            StudentDAO sd = new StudentDAO();
            ArrayList<StudentBean> al = sd.findAll();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewStudents</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>View Student</h1>");
            out.println("<a href='student.html'>Add New Student</a>");
           out.println("<table border ='1'>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Enrollment</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Physics</th>");
            out.println("<th>Hindi</th>");
            out.println("<th>English</th>");
            out.println("<th>Math</th>");
            out.println("<th>Chemistry</th>");
            out.println("<th>Percentages</th>");
            out.println("<th>Status</th>");
             
            out.println("<th>Edit</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
           for(StudentBean e:al){
               out.println("<tr>");
               out.println("<td>"+e.getId()+"</td>");
               out.println("<td>"+e.getEnrollment()+"</td>");
               out.println("<td>"+e.getName()+"</td>");
               out.println("<td>"+e.getEmail()+"</td>");
               out.println("<td>"+e.getP()+"</td>");
               out.println("<td>"+e.getH()+"</td>");
               out.println("<td>"+e.getE()+"</td>");
               out.println("<td>"+e.getM()+"</td>");
               out.println("<td>"+e.getC()+"</td>");
               out.println("<td>"+e.getPer()+"</td>");
               out.println("<td>"+e.getStatus()+"</td>");
               out.println("<td><a href='StudentEditForm?studentno="+e.getId()+"'>Edit</a></td>");
               out.println("<td><a href='DeleteStudent?id="+e.getId()+"'>Delete</a></td>");
               
               out.println("</tr>");
               
           }
           out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
