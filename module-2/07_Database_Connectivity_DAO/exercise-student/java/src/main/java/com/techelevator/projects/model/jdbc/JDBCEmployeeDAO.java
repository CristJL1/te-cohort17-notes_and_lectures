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

		List<Employee> theEmployees = new ArrayList();

		String sqlSearchEmployeesByName = "SELECT * " +
											"FROM employee " +
											"WHERE first_name ilike ? " +
											"AND last_name  ilike  ? ";


		SqlRowSet employeeSearchResult;

		employeeSearchResult = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName, firstNameSearch + "%", lastNameSearch + "%");

		while (employeeSearchResult.next()) {
			Employee anEmployee;
			anEmployee = mapRowToEmployee(employeeSearchResult);

			theEmployees.add(anEmployee);
		}

		return theEmployees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {

		List<Employee> theEmployees = new ArrayList();

		String sqlSearchEmployeesByDepartmentId = "SELECT * " +
											"FROM employee " +
											"WHERE department_id = ? ";

		SqlRowSet employeeSearchResult;

		employeeSearchResult = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByDepartmentId, id);

		while (employeeSearchResult.next()) {
			Employee anEmployee;
			anEmployee = mapRowToEmployee(employeeSearchResult);

			theEmployees.add(anEmployee);
		}

		return theEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {

		List<Employee> theEmployees = new ArrayList();

		String sqlSearchEmployeesWithoutProject = "SELECT * " +
													"FROM employee " +
													"LEFT JOIN project_employee " +
													"ON employee.employee_id = project_employee.employee_id " +
													"WHERE project_employee.employee_id is null;";

		SqlRowSet employeeSearchResult;

		employeeSearchResult = jdbcTemplate.queryForRowSet(sqlSearchEmployeesWithoutProject);

		while (employeeSearchResult.next()) {
			Employee anEmployee;
			anEmployee = mapRowToEmployee(employeeSearchResult);

			theEmployees.add(anEmployee);
		}

		return theEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {

		List<Employee> theEmployees = new ArrayList();

		String sqlSearchEmployeesByDepartmentId = "select * " +
				"from employee " +
				"where employee_id in (select employee_id from project_employee where project_id = ?);";

		SqlRowSet employeeSearchResult;

		employeeSearchResult = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByDepartmentId, projectId);

		while (employeeSearchResult.next()) {
			Employee anEmployee;
			anEmployee = mapRowToEmployee(employeeSearchResult);

			theEmployees.add(anEmployee);
		}

		return theEmployees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {

		String sqlChangeEmployeeDepartment = "update employee " +
				"set department_id = ? " +
				"where employee_id = ?"; //not working



		jdbcTemplate.update(sqlChangeEmployeeDepartment);
		
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee;
		theEmployee = new Employee();

		theEmployee.setEmployee_id(results.getLong("employee_id"));
		theEmployee.setDepartment_id(results.getInt("department_id"));
		theEmployee.setFirst_name(results.getString("first_name"));
		theEmployee.setLast_name(results.getString("last_name"));
		theEmployee.setGender(results.getString("gender"));
		theEmployee.setBirth_date(results.getDate("birth_date").toLocalDate());
		theEmployee.setHire_date(results.getDate("hire_date").toLocalDate());

		return theEmployee;
	}

}
