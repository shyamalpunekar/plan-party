package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by spunek on 8/4/17.
 */
public class PartyTest {

    @Test
    public void runTest_instantiatesCorrectly() throws Exception {
        Party testParty = new Party(10, "snack" , "water" , "none");

        assertEquals(true, testParty instanceof Party);
    }

    @Test
    public void runTest_calculateCost_3500() throws Exception {
        Party testParty = new Party(10, "full course" , "full bar" , "live band");
        assertEquals(3500, testParty.calculateCost());

    }

    @Test
    public void runTest_calculateCostWithUppercase_3500() throws Exception {
        Party testParty = new Party(10, "FULL COURSE" , "FULL BAR" , "LIVE BAND");
        assertEquals(3500, testParty.calculateCost());
    }

}