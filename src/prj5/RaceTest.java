// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu nguyen (nphu01)

package prj5;

import student.TestCase;

/**
 * Race testing class
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.15
 * @author Phu Nguyen (nphu01)
 * @version 2021.11.15
 *
 */
public class RaceTest extends TestCase {

    private Race race;

    /**
     * Runs before every test
     */
    public void setUp() {
        race = new Race("Asian", 10, 2);
    }


    /**
     * Tests getName method
     */
    public void testGetName() {
        assertEquals("Asian", race.getName());
    }


    /**
     * Tests getCases method
     */
    public void testGetCases() {
        assertEquals(10, race.getCases());
    }


    /**
     * Tests getDeaths method
     */
    public void testGetDeaths() {
        assertEquals(2, race.getDeaths());
    }


    /**
     * Tests setCFR method
     */
    public void testSetCFR() {
        race.setCFR(20);
        assertEquals(20, race.getCFR(), 0.01);
    }


    /**
     * Tests getCFR method
     */
    public void testGetCFR() {
        assertEquals(0, race.getCFR(), 0.01);
    }


    /**
     * Tests calculateCFR method
     */
    public void testCalculateCFR() {
        race.calculateCFR();
        assertEquals(20, race.getCFR(), 0.01);
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals("Asian", race.toString());
    }


    /**
     * Tests printContents method
     */
    public void testPrintContents() {
        assertEquals("Asian: 10 cases, 0% CFR", race.printContents());
        race.setCFR(-1);
        assertEquals("Asian: 10 cases, -1% CFR", race.printContents());
        race.setCFR(1.1);
        assertEquals("Asian: 10 cases, 1.1% CFR", race.printContents());
    }


    /**
     * Tests equals method
     */
    public void testEquals() {
        assertTrue(race.equals(race));

        Object n = null;
        assertFalse(race.equals(n));

        assertFalse(race.equals("Test"));

        Race differentName = new Race("White", 10, 2);
        assertFalse(race.equals(differentName));

        Race differentCases = new Race("Asian", 20, 2);
        assertFalse(race.equals(differentCases));

        Race differentDeaths = new Race("Asian", 10, 5);
        assertFalse(race.equals(differentDeaths));

        Race differentCFR = new Race("Asian", 10, 2);
        differentCFR.setCFR(5);
        assertFalse(race.equals(differentCFR));

        Race different = new Race("White", 20, 5);
        different.setCFR(5);
        assertFalse(race.equals(different));

        Race same = new Race("Asian", 10, 2);
        assertTrue(race.equals(same));
    }


    /**
     * Tests compareCFR method
     */
    public void testCompareCFR() {
        race.setCFR(5);

        Race less = new Race("White", 10, 2);
        less.setCFR(2);
        assertEquals(1, race.compareCFR(less));

        Race more = new Race("White", 10, 2);
        more.setCFR(10);
        assertEquals(-1, race.compareCFR(more));

        Race sameName = new Race("Asian", 10, 2);
        sameName.setCFR(5);
        assertEquals(0, race.compareCFR(sameName));

        Race beforeName = new Race("AA", 10, 2);
        beforeName.setCFR(5);
        assertEquals(-1, race.compareCFR(beforeName));

        Race afterName = new Race("ZZ", 10, 2);
        afterName.setCFR(5);
        assertEquals(1, race.compareCFR(afterName));
    }


    /**
     * Tests compareName method
     */
    public void testCompareName() {
        Race before = new Race("AA", 10, 2);
        assertEquals(1, race.compareName(before));

        Race after = new Race("ZZ", 10, 2);
        assertEquals(-1, race.compareName(after));

        Race same = new Race("Asian", 10, 2);
        assertEquals(0, race.compareName(same));
    }
}
