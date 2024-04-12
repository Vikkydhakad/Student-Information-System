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
public class StudentEditForm extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("studentno"));
            StudentDAO ed = new StudentDAO();
            StudentBean eb = ed.findById(id);
            

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentEditForm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Student Update Form</h1>");
            out.println("<form action='UpdateStudentController'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td><input type='hidden' name='id' value=" + eb.getId() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Enrollment</td>");
            out.println("<td><input type='text' name='Enrollment' value=" + eb.getEnrollment() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Name</td>");
            out.println("<td><input type='text' name='name' value=" + eb.getName() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Email</td>");

            out.println("<td><input type='text' name='email' value=" + eb.getEmail() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Physics</td>");
            out.println("<td><input type='text' name='p' value=" + eb.getP() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Hindi</td>");
            out.println("<td><input type='text' name='h' value=" + eb.getH() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>English</td>");
            out.println("<td><input type='text' name='e' value=" + eb.getE() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Math</td>");
            out.println("<td><input type='text' name='m' value=" + eb.getM() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Chemistry</td>");
            out.println("<td><input type='text' name='c' value=" + eb.getC() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Percentages</td>");
            out.println("<td><input type='text' name='per' value=" + eb.getPer() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Status</td>");
            out.println("<td><input type='text' name='status' value=" + eb.getStatus() + "></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>&nbsp;</td>");
            out.println("<td><input type='submit' value='Update Student'</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
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
