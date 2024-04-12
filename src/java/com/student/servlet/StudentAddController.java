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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class StudentAddController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name");
            String Enrollment = request.getParameter("Enrollment");
            String email =request.getParameter("email");
             int p =Integer.parseInt(request.getParameter("p"));
              int h =Integer.parseInt(request.getParameter("h"));
               int e =Integer.parseInt(request.getParameter("e"));
                int m =Integer.parseInt(request.getParameter("m"));
                int c =Integer.parseInt(request.getParameter("c"));
                  int per =Integer.parseInt(request.getParameter("per"));
                   String status =request.getParameter("status");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentAddController</title>");            
            out.println("</head>");
            out.println("<body>");
            StudentBean eb = new StudentBean();
            eb.setEmail(email);
            eb.setEnrollment(Enrollment);
            eb.setName(name);
            eb.setP(p);
            eb.setH(h);
            eb.setE(e);
            eb.setM(m);
            eb.setC(c);
            eb.setPer(per);
            eb.setStatus(status);
            StudentDAO ed = new StudentDAO();
            int x = ed.addStudent(eb);
            if(x>0){
                response.sendRedirect("ViewStudent");
                out.println("<h1><font color='green'>Student Added Success</font></h1>");
            }
            else{
                 out.println("<h1><font color='red'>Student not Added Success</font></h1>");
            }
            
            
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