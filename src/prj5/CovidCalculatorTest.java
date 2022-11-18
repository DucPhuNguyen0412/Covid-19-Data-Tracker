// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import student.TestCase;

/**
 * CovidCalculator testing class
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.30
 * @author Phu Nguyen (nphu01)
 * @version 2021.11.30
 *
 */
public class CovidCalculatorTest extends TestCase {
    private State stateDC;
    private State stateVA;
    private State stateGA;
    private State stateMD;
    private State stateNC;
    private State stateTN;
    private CovidCalculator calc;

    /**
     * Runs before every test
     */
    public void setUp() {
        LinkedList<Race> raceListDC = new LinkedList<Race>();
        raceListDC.add(new Race("White", 70678, 1924));
        raceListDC.add(new Race("Black", 179563, 13365));
        raceListDC.add(new Race("LatinX", 97118, 2269));
        raceListDC.add(new Race("Asian", 5407, 254));
        raceListDC.add(new Race("Other", 108784, 170));

        LinkedList<Race> raceListGA = new LinkedList<Race>();
        raceListGA.add(new Race("White", 1122398, 51012));
        raceListGA.add(new Race("Black", 1199125, 50296));
        raceListGA.add(new Race("LatinX", 601778, 6152));
        raceListGA.add(new Race("Asian", 60426, 1846));
        raceListGA.add(new Race("Other", 1542083, 1848));

        LinkedList<Race> raceListMD = new LinkedList<Race>();
        raceListMD.add(new Race("White", 534910, 44759));
        raceListMD.add(new Race("Black", 764514, 42863));
        raceListMD.add(new Race("LatinX", 635420, 11343));
        raceListMD.add(new Race("Asian", 47733, 3999));
        raceListMD.add(new Race("Other", 539893, 2103));

        LinkedList<Race> raceListNC = new LinkedList<Race>();
        raceListNC.add(new Race("White", 1202651, 30203));
        raceListNC.add(new Race("Black", 525056, 16605));
        raceListNC.add(new Race("LatinX", 787616, -1));
        raceListNC.add(new Race("Asian", 41305, 737));
        raceListNC.add(new Race("Other", 1192110, 6303));

        LinkedList<Race> raceListTN = new LinkedList<Race>();
        raceListTN.add(new Race("White", 1140754, 16926));
        raceListTN.add(new Race("Black", 491709, 9442));
        raceListTN.add(new Race("LatinX", 443364, -1));
        raceListTN.add(new Race("Asian", 25846, 403));
        raceListTN.add(new Race("Other", 847967, 2122));

        LinkedList<Race> raceListVA = new LinkedList<Race>();
        raceListVA.add(new Race("White", 616402, 34311));
        raceListVA.add(new Race("Black", 426362, 14702));
        raceListVA.add(new Race("LatinX", 738177, -1));
        raceListVA.add(new Race("Asian", -1, -1));
        raceListVA.add(new Race("Other", 777332, 5745));

        stateDC = new State("DC", raceListDC);
        stateVA = new State("VA", raceListVA);
        stateGA = new State("GA", raceListGA);
        stateMD = new State("MD", raceListMD);
        stateNC = new State("NC", raceListNC);
        stateTN = new State("TN", raceListTN);
        State[] states = new State[] 
            { stateDC, stateGA, stateMD, stateNC, stateTN, stateVA };
        calc = new CovidCalculator(states);
    }


    /**
     * Tests getStates method
     */
    public void testGetStates() {
        assertEquals(calc.getStates()[0].toString(), stateDC.toString());
        assertEquals(calc.getStates()[1].toString(), stateGA.toString());
        assertEquals(calc.getStates()[2].toString(), stateMD.toString());
        assertEquals(calc.getStates()[3].toString(), stateNC.toString());
        assertEquals(calc.getStates()[4].toString(), stateTN.toString());
        assertEquals(calc.getStates()[5].toString(), stateVA.toString());
    }


    /**
     * Tests getRaceList method
     */
    public void testGetRaceList() {
        assertEquals(calc.getRaceList("VA").toString(), stateVA.getRaceList()
            .toString());
    }


    /**
     * Tests sortAlpha method
     */
    public void testSortAlpha() {
        stateDC.sortAlpha();
        stateVA.sortAlpha();
        stateGA.sortAlpha();
        stateMD.sortAlpha();
        stateNC.sortAlpha();
        stateTN.sortAlpha();
        assertEquals(calc.sortAlpha("VA"), stateVA);
        assertEquals(calc.getRaceList("DC").toString(), stateDC.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("VA").toString(), stateVA.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("GA").toString(), stateGA.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("MD").toString(), stateMD.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("NC").toString(), stateNC.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("TN").toString(), stateTN.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("VA").toString(), stateVA.getRaceList()
            .toString());
    }


    /**
     * Tests sortCFR method
     */
    public void testSortCFR() {
        stateDC.sortCFR();
        stateVA.sortCFR();
        stateGA.sortCFR();
        stateMD.sortCFR();
        stateNC.sortCFR();
        stateTN.sortCFR();
        assertEquals(calc.sortCFR("VA"), stateVA);
        assertEquals(calc.getRaceList("DC").toString(), stateDC.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("VA").toString(), stateVA.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("GA").toString(), stateGA.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("MD").toString(), stateMD.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("NC").toString(), stateNC.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("TN").toString(), stateTN.getRaceList()
            .toString());
        assertEquals(calc.getRaceList("VA").toString(), stateVA.getRaceList()
            .toString());
    }


    /**
     * Tests getStateIndex method
     */
    public void testGetStateIndex() {
        assertEquals(calc.getStateIndex("GA"), 1);
        assertEquals(calc.getStateIndex("GB"), 0);
        assertEquals(calc.getStateIndex(null), 0);
        State oregon = new State("Oregon", null);
        State[] states2 = new State[] {oregon, null, null};
        CovidCalculator calc1 = new CovidCalculator(states2);
        assertEquals(calc1.getStateIndex("Oregon"), 0);
        assertEquals(calc1.getStateIndex(null), 0);
    }

}
