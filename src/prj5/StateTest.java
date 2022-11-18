// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import student.TestCase;

/**
 * State testing class
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.15
 *@author Phu Nguyen (nphu01)
 * @version 2021.11.15
 */
public class StateTest extends TestCase {

    private State dc;
    private Race white;
    private Race black;
    private Race latinX;
    private Race asian;
    private Race other;

    /**
     * Runs before every test
     */
    public void setUp() {
        white = new Race("White", 70678, 1924);
        black = new Race("Black", 179563, 13365);
        latinX = new Race("LatinX", 97118, 2269);
        asian = new Race("Asian", 5407, 254);
        other = new Race("Other", 108784, 170);
        LinkedList<Race> raceList = new LinkedList<Race>();
        raceList.add(white);
        raceList.add(black);
        raceList.add(latinX);
        raceList.add(asian);
        raceList.add(other);

        dc = new State("DC", raceList);
    }


    /**
     * Tests getName method
     */
    public void testGetName() {
        assertEquals("DC", dc.getName());
    }


    /**
     * Tests getRaceList method
     */
    public void testGetRaceList() {
        assertEquals("{White, Black, LatinX, Asian, Other}", dc.getRaceList()
            .toString());
    }


    /**
     * Tests sortAlpha method
     */
    public void testSortAlpha() {
        dc.sortAlpha();
        assertEquals("{Asian, Black, LatinX, Other, White}", dc.getRaceList()
            .toString());
    }


    /**
     * Tests sortCFR method
     */
    public void testSortCFR() {
        latinX.setCFR(1);
        other.setCFR(2);
        white.setCFR(3);
        asian.setCFR(4);
        black.setCFR(5);

        dc.sortCFR();
        assertEquals("{Black, Asian, White, Other, LatinX}", dc.getRaceList()
            .toString());
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        latinX.setCFR(1);
        other.setCFR(2);
        white.setCFR(3);
        asian.setCFR(5);
        black.setCFR(5);

        System.out.println(dc.toString());

        String same = "DC\r\n"
            + "Asian: 5407 cases, 5% CFR\r\n"
            + "Black: 179563 cases, 5% CFR\r\n"
            + "LatinX: 97118 cases, 1% CFR\r\n"
            + "Other: 108784 cases, 2% CFR\r\n"
            + "White: 70678 cases, 3% CFR\r\n"
            + "=====\r\n"
            + "Asian: 5407 cases, 5% CFR\r\n"
            + "Black: 179563 cases, 5% CFR\r\n"
            + "White: 70678 cases, 3% CFR\r\n"
            + "Other: 108784 cases, 2% CFR\r\n"
            + "LatinX: 97118 cases, 1% CFR\r\n"
            + "=====\r\n";

        assertEquals(same, dc.toString());
    }
}
