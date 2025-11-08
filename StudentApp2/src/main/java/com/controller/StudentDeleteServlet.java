package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {

	public StudentDeleteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getContentType();
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		StudentDAO dao = new StudentDAOImpl();

		int count = dao.deleteStudent(id);

		if (count > 0)
			out.print("<h1> SUCCESS </h1>");

		else
			out.print("<h1>FAIL</h1>");
//	
	}

}
