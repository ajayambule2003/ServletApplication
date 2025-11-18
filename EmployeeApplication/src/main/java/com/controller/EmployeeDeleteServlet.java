package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;

@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {

    public EmployeeDeleteServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getContentType();
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAOImpl();

        int count = dao.deleteEmployee(id);

        if (count > 0) {
            out.print("<h1> SUCCESS </h1>");
            RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
            rd.include(request, response);
        } else {
            out.print("<h1>FAIL</h1>");
        }
    }
}
