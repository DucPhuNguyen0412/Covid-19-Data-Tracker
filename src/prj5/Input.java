// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import java.io.FileNotFoundException;

/**
 * Input class that reads the filename with DataReader in args and prints out
 * its data
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.16
 * @author Phu Nguyen
 * @version 2021.11.16
 *
 */
public class Input {

    /**
     * The main method
     * 
     * @param args
     *            String array that holds the filename
     * @throws FileNotFoundException
     *             thrown when the file does not exist
     */
    public static void main(String[] args)
        throws FileNotFoundException {

        String inputFileName;
        if (args.length == 1) {
            inputFileName = args[0];
        }
        else {
            inputFileName = "Cases_and_Deaths_by_race_CRDT_Sep2020.csv";
        }
        DataReader reader = new DataReader(inputFileName);
    }
}
