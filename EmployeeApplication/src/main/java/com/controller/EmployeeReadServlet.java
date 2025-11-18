package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;

@WebServlet("/EmployeeReadServlet")
public class EmployeeReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployeeReadServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDAO dao = new EmployeeDAOImpl();

        List<Employee> empList = dao.getAllEmployees();

        out.print("<head>");
        out.print("<link rel='stylesheet' href='css/table.css'>");
        out.print("</head>");

        Iterator<Employee> itr = empList.iterator();
        out.print("<table border='1px solid black'>");
        out.print("<tr>");
        out.print("<th> ID </th>");
        out.print("<th> NAME </th>");
        out.print("<th> SALARY </th>");
        out.print("</tr>");

        while (itr.hasNext()) {
            Employee employee = itr.next();
            out.print("<tr>");
            out.print("<td>" + employee.getId() + "</td>");
            out.print("<td>" + employee.getName() + "</td>");
            out.print("<td>" + employee.getSalary() + "</td>");

            out.print("<td>");
            out.print("<a href='EmployeeDeleteServlet?id=" + employee.getId() + "'>" + "DELETE" + "</a>");
            out.print("</td>");
            out.print("<td>");
            out.print("<link rel='stylesheet' href='css/form.css'>");
            out.print("<a href='EmployeeUpdateForm?id=" + employee.getId() + "'>" + "UPDATE" + "</a>");
            out.print("</td>");

            out.print("</tr>");
        }
        out.print("</table>");
    }
}
