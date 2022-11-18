// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

/**
 * This object handles the sorting for all the states
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.30
 * @author Phu Nguyen (nphu01)
 * @version 2021.11.30
 */
public class CovidCalculator {
    /**
     * The number of races in the race list for each state
     */
    public final static int NUMS_RACES = 5;
    private State[] states;
    

    /**
     * CovidCalculator object that takes in an array of states
     * 
     * @param s
     *            the array of states
     */
    public CovidCalculator(State[] s) {
        states = s;
    }


    /**
     * Gets the array of states
     * 
     * @return returns the array of states
     */
    public State[] getStates() {
        return states;
    }


    /**
     * Sorts all the race lists of each state in the array alphabetically and
     * returns a specific
     * state
     * 
     * @param s
     *            String representation that is to be sorted alphabetically and
     *            returned
     * @return returns the state from the String parameter after sorting its
     *         race list alphabetically
     */
    public State sortAlpha(String s) {
        for (int i = 0; i < states.length; i++) {
            states[i].sortAlpha();
        }

        int index = getStateIndex(s);
        return states[index];
    }


    /**
     * Sorts all the race lists of each state in the array by their CFRs then
     * returns a specific
     * state
     * 
     * @param s
     *            String representation of the state that is to be sorted by CFR
     *            and returned
     * @return returns the state from the String parameter after sorting its
     *         race list by CFR
     */
    public State sortCFR(String s) {
        for (int i = 0; i < states.length; i++) {
            states[i].sortCFR();
        }
        int index = getStateIndex(s);
        return states[index];
    }


    /**
     * gets the state index
     * 
     * @param state
     *            the state
     * @return returns the states index in the array
     */
    public int getStateIndex(String state) {
        for (int i = 1; i < states.length; i++) {
            if (states[i] != null && states[i].getName().equals(state)) {
                return i;
            }
        }
        return 0;
    }


    /**
     * Gets the race list of a state
     * 
     * @param state
     *            the state with the race list
     * @return returns that state's race list
     */
    public LinkedList<Race> getRaceList(String state) {
        int index = getStateIndex(state);

        return states[index].getRaceList();
    }
}
