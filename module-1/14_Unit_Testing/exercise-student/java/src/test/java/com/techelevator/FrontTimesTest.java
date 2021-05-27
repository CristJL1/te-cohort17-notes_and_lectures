package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FrontTimesTest {

    FrontTimes testCode = new FrontTimes();

    @Test

    public void string_is_not_null () {
        String testString  = "";

        testString = testCode.generateString("Chocolate", 3);

        assertNotNull(testString);
    }

    @Test
    public void string_is_not_empty () {
        String testString  = "";

        testString = testCode.generateString("Chocolate", 3);

        assertNotEquals("", testString);
    }

    @Test
    public void string_is_less_than_3_characters () {
        String testString  = "";

        testString = testCode.generateString("Me", 3);

        assertEquals("MeMeMe", testString);
    }

    @Test
    public void string_is_3_characters_or_more () {
        String testString  = "";

        testString = testCode.generateString("Chocolate", 3);

        assertEquals("ChoChoCho", testString);
    }

}
