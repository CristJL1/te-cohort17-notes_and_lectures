package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AnimalGroupNameTest {



// instantiate an object with the code to be tested
AnimalGroupName theCode = new AnimalGroupName();

// Testing public String getHerd(String animalName)

    // given an animal in the map, return the group name

    @Test
    public void test_that_animal_name_is_in_the_map () {
        // Arrange - set up the data to test the method

    String anAnimal = "giraffe";


        // Act - run the method with the test data and get the result

    String actualGroupName = theCode.getHerd(anAnimal);

        // Assert - verify the result is what was expected

    assertEquals("Tower", actualGroupName);

    }

    @Test // given animal is not in the map
    public void test_that_animal_name_is_NOT_in_the_map () {
        // Arrange - set up the data to test the method

        String anAnimal = "Frank";


        // Act - run the method with the test data and get the result

        String actualGroupName = theCode.getHerd(anAnimal);

        // Assert - verify the result is what was expected

        assertEquals("unknown", actualGroupName);

    }

    @Test // given animal is null
    public void test_that_animal_name_passed_is_null () {
        // Arrange - set up the data to test the method
        // Act - run the method with the test data and get the result

        String actualGroupName = theCode.getHerd(null); // act and arrange together

        // Assert - verify the result is what was expected

        assertEquals("unknown", actualGroupName);

    }

    @Test // given an empty string as an animal
    public void test_that_animal_name_passed_is_empty_string () {
        // Arrange - set up the data to test the method

        String anAnimal = "";

        // Act - run the method with the test data and get the result

        String actualGroupName = theCode.getHerd(anAnimal); // act and arrange together

        // Assert - verify the result is what was expected

        assertEquals("unknown", actualGroupName);

    }

    @Test // given an empty string as an animal
    public void test_that_animal_name_case_does_not_matter () {
        // Arrange - set up the data to test the method

        String anAnimal = "GIRAFFE";

        // Act - run the method with the test data and get the result

        String actualGroupName = theCode.getHerd(anAnimal); // act and arrange together

        // Assert - verify the result is what was expected

        assertEquals("Tower", actualGroupName);

    }




}
