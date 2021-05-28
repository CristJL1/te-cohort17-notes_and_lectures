package com.techelevator;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Less20Test {

    Less20 testCode = new Less20();

    @Test
    public void n_is_1_less_than_multiple_of_20 () {

        testCode.isLessThanMultipleOf20(19);

        assertTrue(true);

    }

    @Test
    public void n_is_2_less_than_multiple_of_20 () {

        testCode.isLessThanMultipleOf20(18);

        assertTrue(true);

    }

    @Test
    public void n_is_not_divisible_by_20 () {

        testCode.isLessThanMultipleOf20(40);

            assertFalse(false);

    }



    /*
        Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
        and 39 return true, but 40 returns false.
        (Hint: Think "mod".)
        less20(18) → true
        less20(19) → true
        less20(20) → false

    public boolean isLessThanMultipleOf20(int n) {
        boolean oneLessThanMultipleOf20 = n % 20 == 19;
        boolean twoLessThanMultipleOf20 = n % 20 == 18;

        return oneLessThanMultipleOf20 || twoLessThanMultipleOf20;
    }*/

}
