package com.techelevator;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Lucky13Test {

    Lucky13 testCode = new Lucky13();

    @Test
    public void array_has_no_1s_or_3s () {

       boolean results;

        int[] testArray = new int []{0,2,4};

      results = testCode.getLucky(testArray);

       assertTrue(results);

    }

    @Test
    public void array_has_1s () {

        boolean results;

        int[] testArray = new int []{1,2,4};

        results = testCode.getLucky(testArray);

        assertFalse(results);

    }

    @Test
    public void array_has_3s () {

        boolean results;

        int[] testArray = new int []{0,3,4};

        results = testCode.getLucky(testArray);

        assertFalse(results);

    }





}
