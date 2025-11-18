package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;

@WebServlet("/EmployeeUpdateForm")
public class EmployeeUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeUpdateForm() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDAO dao = new EmployeeDAOImpl();
		Employee employee = dao.findEmployeeById(id);

		out.print("<head>");
		out.print("<link rel='stylesheet' href='css/update.css'>");
		out.print("</head>");

		out.print("<form action='EmployeeUpdateServlet' method='get'>");

		out.print("<input type='text' name='id' value='" + employee.getId() + "'>");
		out.print("<input type='text' name='name' value='" + employee.getName() + "'>");
		out.print("<input type='text' name='salary' value='" + employee.getSalary() + "'>");

		out.print("<input type='submit' value='UPDATE'>");
		out.print("</form>");
	}
}
