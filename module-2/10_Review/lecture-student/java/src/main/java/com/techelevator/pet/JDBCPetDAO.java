package com.techelevator.pet;
//
// concrete class to implement the code for the DAO
//

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCPetDAO implements PetDAO {

    private JdbcTemplate theDataBase; // object to interact with Spring DAO

    //ctor to receive the datasource and assign it to a JdbcTemplate object
    public JDBCPetDAO(DataSource theDataSource) {

        theDataBase = new JdbcTemplate(theDataSource);

    }


    @Override
    public List<Pet> getAllPets() {

        // define the object to be returned
        List<Pet> thePets = new ArrayList<>();

        // define the SQL statement to access the database
        String getAllPetsSQL = "Select * from Pet;";

        // run the SQL and store the result
        SqlRowSet resultsFromSelect = theDataBase.queryForRowSet(getAllPetsSQL);

        //copy the data from the SQL results into our List that we are returning
        while (resultsFromSelect.next()) { // loop while there is a row in the result and position to the next row
            thePets.add(MapRowToPet(resultsFromSelect));
        }

        // return the object created to be returned
        return thePets;
    }

    @Override
    public Pet getAPet(Long petId) {
        return null;
    }

    @Override
    public void addPet(Pet aPet) {

    }

    @Override
    public Pet updatePet(Pet aPet) {
        return null;
    }

    // helper method to copy the data from a row in a result to a Pet object

    private Pet MapRowToPet (SqlRowSet theRow) {
        //define object to be returned

        Pet aPet = new Pet();

        aPet.setName(theRow.getString("name")); // copy the name column from the result to the Pet object
        aPet.setPetId(theRow.getLong("petid"));
        aPet.setOwnerId(theRow.getInt("ownerid"));
        aPet.setPetType(theRow.getInt("pettype"));
        aPet.setWhenAdded(theRow.getTimestamp("whenadded").toLocalDateTime());
        aPet.setLastUpdate(theRow.getTimestamp("whenadded").toLocalDateTime());



        return aPet;

    }

}
