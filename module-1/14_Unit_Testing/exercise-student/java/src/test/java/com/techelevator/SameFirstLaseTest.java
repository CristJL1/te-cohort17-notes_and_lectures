package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SameFirstLaseTest {

    SameFirstLast testCode = new SameFirstLast();

    @Test
    public void array_has_a_length_of_at_least_1 () {

        boolean result;

        int [] testArray = new int[]{1};

        result = testCode.isItTheSame(testArray);

        assertTrue(result);


    }

    @Test
    public void first_element_and_last_element_do_not_match () {

        boolean result;

        int [] testArray = new int[]{1,2,1,4};

        result = testCode.isItTheSame(testArray);

        assertFalse(result);


    }

    @Test
    public void first_element_and_last_element_do_match () {

        boolean result;

        int [] testArray = new int[]{1,1};

        result = testCode.isItTheSame(testArray);

        assertTrue(result);


    }



    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true

    public boolean isItTheSame(int[] nums) {
        if (nums == null) return false;
        else return nums.length > 0 && nums[0] == nums[nums.length - 1];
    }*/

}
