package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.util.DBUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	public int saveEmployee(Employee employee) {
		int noOfRows = 0;
		String sql = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());

			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Add Employee " + e.getMessage());
		}
		return noOfRows;
	}

	public int updateEmployee(Employee employee) {
		int noOfRows = 0;
		String sql = "UPDATE EMPLOYEE SET name=?, salary=? WHERE id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setInt(3, employee.getId());

			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("UPDATE Employee " + e.getMessage());
		}
		return noOfRows;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				empList.add(emp);
			}
		} catch (Exception e) {
			System.err.println("READ ALL Employee " + e.getMessage());
		}
		return empList;
	}

	public Employee findEmployeeById(int id) {
		Employee emp = null;
		String sql = "SELECT * FROM EMPLOYEE WHERE id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (Exception e) {
			System.err.println("READ Employee BY ID " + e.getMessage());
		}
		return emp;
	}

	public int deleteEmployee(int id) {
		int noOfRows = 0;
		String sql = "DELETE FROM EMPLOYEE WHERE id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("DELETE Employee " + e.getMessage());
		}
		return noOfRows;
	}
}
