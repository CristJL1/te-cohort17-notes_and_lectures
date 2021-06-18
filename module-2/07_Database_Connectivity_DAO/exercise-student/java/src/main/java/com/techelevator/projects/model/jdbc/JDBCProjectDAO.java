package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {

		List<Project> theProjects = new ArrayList();

		String sqlSelectAllProjects = "SELECT * " +
				"FROM project " +
				"WHERE to_date is null;";

		SqlRowSet allTheProjects;

		allTheProjects = jdbcTemplate.queryForRowSet(sqlSelectAllProjects);

		while (allTheProjects.next()) {
			Project aProject;
			aProject = mapRowToProject(allTheProjects);

			theProjects.add(aProject);
		}

		return theProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project theProject;
		theProject = new Project();

		theProject.setProject_id(results.getLong("project_id"));
		theProject.setName(results.getString("name"));
		theProject.setFrom_date(results.getDate("from_date").toLocalDate());
		theProject.setTo_date(results.getDate("to_date").toLocalDate());

		return theProject;
	}

}
