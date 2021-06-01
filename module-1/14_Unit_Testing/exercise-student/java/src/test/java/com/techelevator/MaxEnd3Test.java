package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MaxEnd3Test {

    MaxEnd3 testCode = new MaxEnd3();


    @Test
    public void last_number_is_larger () {

        int [] result;

        int [] expected = new int []{7,7,7};

        int [] testArray = new int[]{3,5,7};

        result = testCode.makeArray(testArray);

        assertArrayEquals(expected, result);


    }

    @Test
    public void first_number_is_larger () {

        int [] result;

        int [] expected = new int []{7,7,7};

        int [] testArray = new int[]{7,5,3};

        result = testCode.makeArray(testArray);

        assertArrayEquals(expected, result);


    }

    @Test
    public void middle_number_is_larger_than_both () {

        int [] result;

        int [] expected = new int []{7,7,7};

        int [] testArray = new int[]{7,11,3};

        result = testCode.makeArray(testArray);

        assertArrayEquals(expected, result);


    }


}
