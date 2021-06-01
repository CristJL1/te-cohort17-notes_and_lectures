package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StringBitsTest {

    StringBits testCode = new StringBits();

    @Test
    public void returns_every_other_character () {

        String result = "";

        String expected = "Hello";

        result = testCode.getBits("H9e8l7l6o");


        assertEquals(expected, result);

    }

    @Test
    public void string_is_not_null () {

        String result = "";

        String expected = null;

        result = testCode.getBits("Hello");


        assertNotEquals(expected, result);

    }

    /*
     * Given a string, return a new string made of every other char starting with
     * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
     * → "H" GetBits("Heeololeo") → "Hello"

    public String getBits(String str) {
        String result = "";
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    result += str.charAt(i);
                }
            }
        }
        return result;
    }*/



}
