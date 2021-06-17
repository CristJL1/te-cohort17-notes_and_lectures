package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {

		List<Department> theDepartments = new ArrayList();

		String sqlSelectAllDepartments = "SELECT * " +
										 "FROM Department;";

		SqlRowSet allTheDepartments;

		allTheDepartments = jdbcTemplate.queryForRowSet(sqlSelectAllDepartments);

		while (allTheDepartments.next()) {
			Department aDepartment;
			aDepartment = mapRowToDepartment(allTheDepartments);

			theDepartments.add(aDepartment);
		}

		return theDepartments;

	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {

		List<Department> theDepartments = new ArrayList();

		String sqlSelectDepartmentByName = "SELECT * " +
										"FROM department " +
										"WHERE name ilike ?";

		SqlRowSet departmentSearchResult;

		departmentSearchResult = jdbcTemplate.queryForRowSet(sqlSelectDepartmentByName, nameSearch);

		while (departmentSearchResult.next()) {
			Department aDepartment;
			aDepartment = mapRowToDepartment(departmentSearchResult);

			theDepartments.add(aDepartment);
		}

		return theDepartments;


	}

	@Override
	public void saveDepartment(Department updatedDepartment) {

		String sqlSaveDepartment = "INSERT INTO department (department_id, name) " +
								   "VALUES (?, ?)";

		updatedDepartment.setDepartment_id(getNextDepartmentId());

		jdbcTemplate.update(sqlSaveDepartment, updatedDepartment.getDepartment_id(),
												updatedDepartment.getName());
		
	}

	@Override
	public Department createDepartment(Department newDepartment) {

		String sqlCreateDepartment = "INSERT INTO department (name) " +
				"VALUES (?)";

		newDepartment.setDepartment_id(getNextDepartmentId());

		jdbcTemplate.update(sqlCreateDepartment, newDepartment.getName());

		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartment = null;

		String sqlGetDepartmentById = "SELECT department_id, name " +
										"FROM department " +
										"WHERE department_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartmentById, id);

		if (results.next()) {
			theDepartment = mapRowToDepartment(results);
		}

		return theDepartment;

	}

	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("select nextval('seq_department_id')");

		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}
		else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment;
		theDepartment = new Department();

		theDepartment.setDepartment_id(results.getLong("department_id"));
		theDepartment.setName(results.getString("name"));

		return theDepartment;
	}

}
