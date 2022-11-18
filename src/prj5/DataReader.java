// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import java.io.*;
import java.util.Scanner;
import prj5.LinkedList.Node;

/**
 * DataReader class reads the file
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.16
 * @author Phu Nguyen
 * @version 2021.11.16
 *
 */
public class DataReader {

    private State[] states;

    /**
     * DataReader object that takes in a filename then reads the file of all the
     * states and the cases and deaths for each race
     * 
     * @param inputFileName
     *            the name of the file being read
     * @throws FileNotFoundException
     *             thrown when the file does not exist
     */
    public DataReader(String inputFileName)
        throws FileNotFoundException {
        states = readInputFile(inputFileName);
        GUICovidWindow window = new GUICovidWindow(new CovidCalculator(states), states);
    }


    /**
     * Takes a filename then creates an array of States with the information on
     * the file
     * 
     * @param inputFileName
     *            the name of the file being read
     * @return returns an array of states with the information on the file
     * @throws FileNotFoundException
     *             thrown when the file does not exist
     */
    public State[] readInputFile(String inputFileName)
        throws FileNotFoundException {
        State[] localStates = new State[6];
        File input = new File(inputFileName);

        if (!input.exists()) {
            throw new FileNotFoundException();
        }

        Scanner file = new Scanner(input);

        int counter = 0;
        file.nextLine();
        while (file.hasNextLine() && counter < 6) {
            String[] split = file.nextLine().split(",");

            String name = split[0];
            for (int i = 1; i < 11; i++) {
                if (split[i].equals("NA")) {
                    split[i] = "-1";
                }
            }
            int whiteCases = Integer.valueOf(split[1]);
            int blackCases = Integer.valueOf(split[2]);
            int latinXCases = Integer.valueOf(split[3]);
            int asianCases = Integer.valueOf(split[4]);
            int otherCases = Integer.valueOf(split[5]);
            int whiteDeaths = Integer.valueOf(split[6]);
            int blackDeaths = Integer.valueOf(split[7]);
            int latinXDeaths = Integer.valueOf(split[8]);
            int asianDeaths = Integer.valueOf(split[9]);
            int otherDeaths = Integer.valueOf(split[10]);

            Race white = new Race("white", whiteCases, whiteDeaths);
            Race black = new Race("black", blackCases, blackDeaths);
            Race latinx = new Race("latinx", latinXCases, latinXDeaths);
            Race asian = new Race("asian", asianCases, asianDeaths);
            Race other = new Race("other", otherCases, otherDeaths);
            LinkedList<Race> raceList = new LinkedList<Race>();
            raceList.add(white);
            raceList.add(black);
            raceList.add(latinx);
            raceList.add(asian);
            raceList.add(other);

            localStates[counter] = new State(name, raceList);
            counter++;
        }
        for (int i = 0; i < localStates.length; i++) {
            Node<Race> current = localStates[i].getRaceList().getHead();

            while (current != null) {
                if (current.getData().getCases() == -1 || current.getData()
                    .getDeaths() == -1) {
                    current.getData().setCFR(-1);
                }
                else {
                    current.getData().calculateCFR();
                }
                current = current.next();
            }
        }
        file.close();
        return localStates;
    }


    /**
     * Creates a string representation of the contents of each state in the
     * array
     * 
     * @return returns a string representation of each state in the array
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < states.length; i++) {
            str += states[i].toString();
        }
        return str;
    }
}
