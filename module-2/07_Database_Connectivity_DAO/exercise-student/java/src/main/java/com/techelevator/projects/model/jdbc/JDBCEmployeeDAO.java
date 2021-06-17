package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> theEmployees = new ArrayList();

		String sqlSelectAllEmployees = "SELECT * " +
									"FROM Employee;";

		SqlRowSet allTheEmployees;

		allTheEmployees = jdbcTemplate.queryForRowSet(sqlSelectAllEmployees);

		while (allTheEmployees.next()) {
			Employee anEmployee;
			anEmployee = mapRowToEmployee(allTheEmployees);

			theEmployees.add(anEmployee);
		}

		return theEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {

		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {

		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {

		return new ArrayList<>();
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee;
		theEmployee = new Employee();

		theEmployee.setEmployee_id(results.getLong("employee_id"));
		theEmployee.setDepartment_id(results.getInt("department_id"));
		theEmployee.setFirst_name(results.getString("first_name"));
		theEmployee.setLast_name(results.getString("last_name"));
		theEmployee.setGender(results.getString("gender"));
		theEmployee.setBirth_date(results.getDate("birth_date"));
		theEmployee.setHire_date(results.getDate("hire_date"));

		return theEmployee;
	}

}
