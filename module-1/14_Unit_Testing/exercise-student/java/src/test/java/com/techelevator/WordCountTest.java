package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;



import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class WordCountTest {

    WordCount testCode = new WordCount();

    @Test
    public void array_is_not_empty () {

        Map<String, Integer> result;

        String [] testArray = new String[]{"ba", "ba", "black", "sheep"};

        result = testCode.getCount(testArray);

        assertNotNull(result);

    }


    @Test
    public void counts_number_of_times_string_appears () {

        Map<String,Integer> expected = new HashMap<>();

        expected.put("ba", 2);

        expected.put("black", 1);

        expected.put("sheep", 1);

        Map<String, Integer> result;

        String [] testArray = new String[]{"ba", "ba", "black", "sheep"};

        result = testCode.getCount(testArray);

        assertEquals(expected, result);

    }






    /*
     * Given an array of strings, return a Dictionary<string, int> with a key for
     * each different string, with the value the number of times that string appears
     * in the array.
     *
     * ** A CLASSIC **
     *
     * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
     * getCount([]) → {}
     * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
     *

    public Map<String, Integer> getCount(String[] words) {
        Map<String, Integer> output = new HashMap<>();

        if (words != null) {
            for (String word : words) {
                if (!output.containsKey(word)) {
                    output.put(word, 1);
                } else {
                    output.put(word, output.get(word) + 1);
                }
            }
        }

        return output;
    }*/

}
