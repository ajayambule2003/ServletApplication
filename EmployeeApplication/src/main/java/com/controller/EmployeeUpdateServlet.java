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
import com.model.Employee;

@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeUpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(id, name, salary);

        EmployeeDAO dao = new EmployeeDAOImpl();
        int count = dao.updateEmployee(employee);

        if (count > 0) {
            out.print("<h1> SUCCESS </h1>");
            RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
            rd.include(request, response);
        } else {
            out.print("<h1>FAIL</h1>");
        }
    }
}
