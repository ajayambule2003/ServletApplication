package com.dao;

import java.util.List;
import com.model.Employee;

public interface EmployeeDAO {

    int saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    int updateEmployee(Employee employee);

    Employee findEmployeeById(int id);

    int deleteEmployee(int id);
}
