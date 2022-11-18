// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import prj5.LinkedList.Node;

/**
 * State class that holds the state name and a Linkedlist of Races
 * 
 * @author Vy Dinh (vyd)
 * @version 2021.11.15
 *@author Phu Nguyen (nphu01)
 * @version 2021.11.15
 */
public class State {

    private String name;
    private LinkedList<Race> raceList;

    /**
     * Creates a State object
     * 
     * @param name
     *            Name of the state
     * @param raceList
     *            List of Races
     */
    State(String name, LinkedList<Race> raceList) {
        this.name = name;
        this.raceList = raceList;

    }


    /**
     * Gets the name of the state
     * 
     * @return returns the name of the state
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the race list of the state
     * 
     * @return returns the race list of the state
     */
    public LinkedList<Race> getRaceList() {
        return raceList;
    }


    /**
     * Sorts the race list alphabetically by name
     */
    public void sortAlpha() {
        Node<Race> unsortedPart = raceList.getHead().next();
        Node<Race> sortedPart = raceList.getHead();
        sortedPart.setNext(null);

        while (unsortedPart != null) {
            Node<Race> nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.next();

            Race item = nodeToInsert.getData();
            Node<Race> currentNode = raceList.getHead();
            Node<Race> previousNode = null;

            while ((currentNode != null) && (item.compareName(currentNode
                .getData()) > 0)) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }

            if (previousNode != null) {
                previousNode.setNext(nodeToInsert);
                nodeToInsert.setNext(currentNode);
            }
            else {
                nodeToInsert.setNext(raceList.getHead());
                raceList.setHead(nodeToInsert);
            }
        }
    }


    /**
     * Sorts the race list by CFR in ascending order
     */
    public void sortCFR() {
        Node<Race> unsortedPart = raceList.getHead().next();
        Node<Race> sortedPart = raceList.getHead();
        sortedPart.setNext(null);

        while (unsortedPart != null) {
            Node<Race> nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.next();

            Race item = nodeToInsert.getData();
            Node<Race> currentNode = raceList.getHead();
            Node<Race> previousNode = null;

            while ((currentNode != null) && (item.compareCFR(currentNode
                .getData()) < 0)) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }

            if (previousNode != null) {
                previousNode.setNext(nodeToInsert);
                nodeToInsert.setNext(currentNode);
            }
            else {
                nodeToInsert.setNext(raceList.getHead());
                raceList.setHead(nodeToInsert);
            }
        }
    }


    /**
     * String representation of the contents of each race in the race list of
     * the state
     * 
     * @return returns contents of state
     */
    public String toString() {
        String str = "" + name + "\n";

        sortAlpha();
        Node<Race> current = raceList.getHead();
        while (current != null) {
            str += current.getData().printContents() + "\n";
            current = current.next();
        }
        str += "=====\n";

        sortCFR();
        current = raceList.getHead();
        while (current != null) {
            str += current.getData().printContents() + "\n";
            current = current.next();
        }
        str += "=====\n";

        return str;
    }

}
