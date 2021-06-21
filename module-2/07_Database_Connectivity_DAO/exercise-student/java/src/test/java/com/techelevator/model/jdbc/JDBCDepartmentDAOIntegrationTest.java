package com.techelevator.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JDBCDepartmentDAOIntegrationTest {

   // private static final String TEST_DEPARTMENT = "ABC123 Department Test";

    private static SingleConnectionDataSource dataSource;

    private JDBCDepartmentDAO dao;

    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/projectsDAO");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    @Before
    public void setup() {
//        String sqlInsertDepartment = "INSERT INTO department (name) " +
//                                        "VALUES (?);";
//
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//        jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT);

        dao = new JDBCDepartmentDAO(dataSource);
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void create_new_department_and_read_it_back () throws SQLException {
        Department theDepartment = getDepartment("ABC123"); //create new test department

        dao.createDepartment(theDepartment); // add the test department to the table

        Department newDepartment = dao.getDepartmentById(theDepartment.getDepartment_id());

        assertNotEquals(null, theDepartment.getDepartment_id()); // verify test department was assigned an ID
        assertDepartmentsAreEqual(theDepartment, newDepartment); // verify that department returned matches department sent
                                                                // giving a null pointer exception, unsure how to fix
    }

    private Department getDepartment (String name) {
        Department theDepartment = new Department();
        theDepartment.setName(name);
        return theDepartment;
    }

    private void assertDepartmentsAreEqual (Department expected, Department actual) {
        assertEquals(expected.getDepartment_id(), actual.getDepartment_id());
        assertEquals(expected.getName(), actual.getName());
    }


}
