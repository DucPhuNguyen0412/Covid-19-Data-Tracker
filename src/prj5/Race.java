// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import java.text.DecimalFormat;

/**
 * Race class that holds the name, number of cases, and number of deaths
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.15
 * @author Phu Nguyen (nphu01)
 * @version 2021.11.15
 */
public class Race {

    private String name;
    private int cases;
    private int deaths;
    private double cfr;

    /**
     * Creates a Race object
     * 
     * @param name
     *            Name of the race
     * @param cases
     *            Number of cases
     * @param deaths
     *            Number of deaths
     */
    public Race(String name, int cases, int deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        cfr = 0;
    }


    /**
     * Gets the name of the race
     * 
     * @return returns the name of the race
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the number of cases
     * 
     * @return returns the number of cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * Gets the number of deaths
     * 
     * @return returns the number of deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Gets the CFR
     * 
     * @return returns the CFR
     */
    public double getCFR() {
        return cfr;
    }


    /**
     * Sets the CFR
     * 
     * @param setCFR
     *            Number the CFR of the race is set to
     */
    public void setCFR(double setCFR) {
        cfr = setCFR;
    }


    /**
     * Calculates the CFR and sets the CFR
     */
    public void calculateCFR() {
        DecimalFormat format = new DecimalFormat("#.0");
        String calculatedCFR = format.format((double)deaths / cases * 100);
        this.cfr = Double.parseDouble(calculatedCFR);
    }


    /**
     * String representation of the name of the race
     * 
     * @return returns the String representation of the name of the race
     */
    public String toString() {
        return "" + name;
    }


    /**
     * String representation of the contents of race
     * 
     * @return returns the String representation of the contents of race
     */
    public String printContents() {
        if (cfr % 1 == 0) {
            int intCFR = (int)cfr;
            return "" + name + ": " + cases + " cases, " + intCFR + "% CFR";
        }
        else {
            return "" + name + ": " + cases + " cases, " + cfr + "% CFR";
        }
    }


    /**
     * Checks if the object is equal to the race
     * 
     * @param obj
     *            object that is checked if equal
     * @return returns true if the object is equal to the race with the same
     *         name, number of cases, number of deaths, and CFR
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Race other = ((Race)obj);
            return (this.name.equals(other.name) && this.cases == other.cases
                && this.deaths == other.deaths && this.cfr == other.cfr);
        }

        return false;
    }


    /**
     * Compares the CFR of the two races. If the same CFR compare alphabetically
     * 
     * @param other
     *            The other race whose CFR we are comparing
     * 
     * @return returns -1 if the current race's CFR is less than the other
     *         race's CFR, 1 if the current race's CFR is more than the other
     *         race's CFR, and 0 if they are equal.
     */
    public int compareCFR(Race other) {
        if (this.cfr < other.cfr) {
            return -1;
        }
        else if (this.cfr > other.cfr) {
            return 1;
        }
        else if (this.name.compareTo(other.name) < 0) {
            return 1;
        }
        else if (this.name.compareTo(other.name) > 0) {
            return -1;
        }
        else {
            return 0;
        }
    }


    /**
     * Compares the names of the the two races
     * 
     * @param other
     *            The other race whose name we are comparing
     * @return returns -1 if the current race's name comes before the other
     *         race's, returns 1 if the current race's name comes after the
     *         other race's, and 0 if they are equal.
     */
    public int compareName(Race other) {
        if (this.name.compareTo(other.name) < 0) {
            return -1;
        }
        if (this.name.compareTo(other.name) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
