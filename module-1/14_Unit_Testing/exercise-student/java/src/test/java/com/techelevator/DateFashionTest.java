package com.techelevator;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DateFashionTest {


    DateFashion testCode = new DateFashion();

    @Test

    public void get_a_table_because_you_are_fashionable () {

        int fashionScore = 0;

       fashionScore = testCode.getATable(8,3);

        assertEquals(2, fashionScore);

    }

    @Test

    public void get_a_table_because_your_date_is_fashionable () {

        int fashionScore = 0;

        fashionScore = testCode.getATable(3,8);

        assertEquals(2, fashionScore);

    }

    @Test

    public void denied_a_table_because_your_date_is_unfashionable () {

        int fashionScore = 0;

        fashionScore = testCode.getATable(8,2);

        assertEquals(0, fashionScore);

    }

    @Test

    public void denied_a_table_because_you_are_unfashionable () {

        int fashionScore = 0;

        fashionScore = testCode.getATable(2,8);

        assertEquals(0, fashionScore);

    }

    @Test
    public void possible_table_because_both_of_you_are_moderately_fashionable () {

        int fashionScore = 0;

        fashionScore = testCode.getATable(7,7);

        assertEquals(1, fashionScore);

    }


}
