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

@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {

    private EmployeeDAO dao;

    public EmployeeAddServlet() {
    }

    @Override
    public void init() throws ServletException {
        dao = new EmployeeDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(id, name, salary);
        int count = dao.saveEmployee(employee);

        if (count > 0) {
            out.print("<h1>SUCCESS</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
            rd.include(request, response);
        } else {
            out.print("<h1>FAIL</h1>");
        }
    }
}
