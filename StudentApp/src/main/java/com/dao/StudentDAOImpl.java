package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.DBUtility;

public class StudentDAOImpl implements StudentDAO {
	// try with resource
	public int saveStudent(Student student) {
		int noOfRows = 0;
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setFloat(3, student.getMarks());
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Add Student " + e.getMessage());
		}
		return noOfRows;
	}

	// try with resource
	public int updateStudent(Student student) {
		int noOfRows = 0;
		String sql = "UPDATE STUDENT SET name=? , marks=? WHERE id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, student.getName());
			ps.setFloat(2, student.getMarks());
			ps.setInt(3, student.getId());
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("UPDATE Student " + e.getMessage());
		}

		return noOfRows;
	}

	public List<Student> getAllStudents() {
		List<Student> studentsList = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getFloat(3));
				studentsList.add(student);
			}
		} catch (Exception e) {
			System.err.println("READ ALL Student " + e.getMessage());
		}
		return studentsList;
	}

	public Student findStudentById(int id) {
		Student student = null;
		String sql = "SELECT * FROM STUDENT WHERE id=?";

		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
		} catch (Exception e) {
			System.err.println("READ Student BY ID " + e.getMessage());
		}
		return student;
	}

	// try with resource
	public int deleteStudent(int id) {
		int noOfRows = 0;
		String sql = "DELETE FROM STUDENT WHERE id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			noOfRows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("DELEET Student " + e.getMessage());
		}
		return noOfRows;
	}

}
