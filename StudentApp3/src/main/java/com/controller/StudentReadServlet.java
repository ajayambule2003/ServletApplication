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

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

@WebServlet("/StudentReadServlet")
public class StudentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentReadServlet() { 
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		StudentDAO dao = new StudentDAOImpl(); 

		List<Student> studList = dao.getAllStudents();

		out.print("<head>");
		out.print("<link rel='stylesheet' href='css/table.css'>");

		out.print("</head>");

		Iterator<Student> itr = studList.iterator();
		out.print("<table border='1px solid black'>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> MARKS </th>");
		out.print("</tr>");

		while (itr.hasNext()) {

			Student student = itr.next();
			out.print("<tr>");
			out.print("<td>" + student.getId() + "</td>");
			out.print("<td>" + student.getName() + "</td>");
			out.print("<td>" + student.getMarks() + "</td>");
			
			out.print("<td>");
			out.print("<a href='StudentDeleteServlet?id="+student.getId()+"'>"+"DELETE"+"</a>");
			out.print("</td>");
			out.print("<td>");
			//
			out.print("<link rel='stylesheet' href='css/form.css'>");

			out.print("<a href='StudentUpdateForm?id="+student.getId()+"'>"+"UPDATE"+"</a>");
			out.print("</td>");
			
			out.print("</tr>");
		}
		out.print("</table>");
	}

}
