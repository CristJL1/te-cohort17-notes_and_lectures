package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NonStartTest {

    NonStart testCode = new NonStart();

    @Test
    public void first_letter_is_omitted () {

        String result = "";

        String expected = "ellohere";


        result = testCode.getPartialString("Hello", "There");

        assertEquals(expected, result);


    }

    @Test
    public void length_of_string_is_at_least_1 () {

        String result = "";

        int expected = 0;


        result = testCode.getPartialString("A", "B");

        assertEquals(expected, result.length());


    }

    @Test
    public void string_returns_if_one_input_is_only_one_letter () {

        String result = "";

        String expected = "C";


        result = testCode.getPartialString("A", "BC");

        assertEquals(expected, result);


    }



}
