package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by spunek on 8/4/17.
 */
public class PartyTest {

    @Test
    public void runTest_instantiatesCorrectly() throws Exception {
        Party testParty = new Party(10, "snack" , "water" , "none", true);

        assertEquals(true, testParty instanceof Party);
    }

    @Test
    public void runTest_calculateCost_3500() throws Exception {
        Party testParty = new Party(10, "full course" , "full bar" , "live band", true);
        assertEquals(3500, testParty.calculateCost(true, true));

    }

    @Test
    public void runTest_calculateCostWithUppercase_3500() throws Exception {
        Party testParty = new Party(10, "FULL COURSE" , "FULL BAR" , "LIVE BAND", true);
        assertEquals(3500, testParty.calculateCost(true, true));
    }

    @Test
    public void runTest_calculateCostWith_3450() throws Exception {
        Party testParty = new Party(10, "FULL COURSE" , "FULL BAR" , "LIVE BAND", false);
        assertEquals(3450, testParty.calculateCost(true, false));
    }

    @Test
    public void runTest_calculateCostWithguest150_true() throws Exception {
        Party testParty = new Party(150, "FULL COURSE" , "FULL BAR" , "LIVE BAND", true);
        assertEquals(21650, testParty.calculateCost(true, false));
    }


    @Test
    public void runTest_calculateCostWithguest100_true() throws Exception {
        Party testParty = new Party(50, "FULL COURSE" , "FULL BAR" , "LIVE BAND", true);
        assertEquals(8650, testParty.calculateCost(true, false));
    }

    @Test
    public void runTest_calculateCostWithGuest100_21650() throws Exception {
        Party testParty = new Party(100, "FULL COURSE" , "FULL BAR" , "LIVE BAND", false);
        assertEquals(21650, testParty.calculateCost(true, false));
    }

    @Test
    public void runTest_calculateCostWithGuest100_true() throws Exception {
        Party testParty = new Party(100, "FULL COURSE" , "FULL BAR" , "LIVE BAND", true);
        assertEquals(21650, testParty.calculateCost(true, false));
    }

    @Test
    public void runTest_calculateCostWith100Guests_Beverages() throws Exception {
        Party testParty = new Party(100, "FULL COURSE" , "Light Refreshments" , "LIVE BAND", true);
        assertEquals(11100, testParty.calculateCost(true, true));
    }




}