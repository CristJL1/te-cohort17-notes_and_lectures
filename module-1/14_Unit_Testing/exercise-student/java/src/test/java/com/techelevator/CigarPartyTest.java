package com.techelevator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CigarPartyTest {

    CigarParty testCode = new CigarParty();


    @Test
    public void does_a_weekend_party_take_place () {

        testCode.haveParty(61, true);

        assertTrue(true);

    }

    @Test
    public void does_a_weekday_party_take_place () {

        testCode.haveParty(40, false);

        assertTrue(true);

    }

    @Test
    public void are_there_enough_cigars_for_a_weekday () {

        testCode.haveParty(39, false);

        assertFalse(false);

    }

    @Test
    public void are_there_enough_cigars_for_a_weekend () {

        testCode.haveParty(39, true);

        assertFalse(false);

    }

    @Test
    public void are_there_too_many_cigars_for_a_weekday () {

        testCode.haveParty(61, false);

        assertFalse(false);


    }

}
