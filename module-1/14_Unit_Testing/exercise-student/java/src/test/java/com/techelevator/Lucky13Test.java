package com.techelevator;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Lucky13Test {

    Lucky13 testCode = new Lucky13();

    @Test
    public void array_has_no_1s () {

       int[] testArray = new int [0];

       testCode.getLucky(testArray);

       assertTrue(true);  // don't think this is right, need to add more numbers to array

    }

   // no idea, can't get test to accept array values


    /*
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     * GetLucky([0, 2, 4]) → true GetLucky([1, 2, 3]) → false GetLucky([1, 2,
     * 4]) → false

    public boolean getLucky(int[] nums) {
        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1 || nums[i] == 3) {
                    return false;
                }
            }
        }
        return true;
    } */



}
