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
import com.model.Student;

@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	
	private StudentDAO dao;

	public StudentAddServlet() {
	}
	@Override
	public void init() throws ServletException {

		dao = new StudentDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float marks = Float.parseFloat(request.getParameter("marks"));

		Student student = new Student(id, name, marks);
//
//		StudentDAO dao = new StudentDAOImpl();
		int count = dao.saveStudent(student);

		if (count > 0)
			out.print("<h1> SUCCESS </h1>");

		else
			out.print("<h1>FAIL</h1>");

	}

}
