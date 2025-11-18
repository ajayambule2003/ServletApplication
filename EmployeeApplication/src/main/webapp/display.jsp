<%@page import="java.util.Iterator"%>
<%@page import="com.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.EmployeeDAOImpl"%>
<%@page import="com.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Record</title>
<link rel="stylesheet" href="css/table.css">
</head>
<body>
	<%
	EmployeeDAO dao = new EmployeeDAOImpl();
	List<Employee> empList = dao.getAllEmployees();
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<%
		Iterator<Employee> itr = empList.iterator();
		while (itr.hasNext()) {
			Employee emp = itr.next();
		%>

		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getSalary()%></td>
			<td>
				<%
				out.print("<a href='EmployeeDeleteServlet?id=" + emp.getId() + "'>" + "DELETE" + "</a>");
				%>
			</td>
			<td>
				<%
				out.print("<a href='EmployeeUpdateForm?id=" + emp.getId() + "'>" + "UPDATE" + "</a>");
				%>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>
