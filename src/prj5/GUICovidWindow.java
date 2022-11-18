// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vy Dinh (vyd) & Phu Nguyen (nphu01)

package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class GUICovidWindow {
    private CovidCalculator calculator;
    private Window window;
    private Button sortAlpha;
    private Button sortCFR;
    private Button quit;
    private Button DC;
    private Button GA;
    private Button MD;
    private Button NC;
    private Button TN;
    private Button VA;
    private Button lastClicked;
    /**
     * The standard width for bars
     */
    private final int BAR_WIDTH = 25;
    /**
     * The gap between bars
     */
    private final int BAR_GAP_FACTOR = 100;
    /**
     * center the bars with the states' name
     */
    private final int BAR_CENTER = 7;
    /**
     * center the NA data with the states' name
     */
    private final int NA_CENTER = 5;
    /**
     * y-axis value of races
     */
    private final int RACE_Y = 210;
    /**
     * y-axis value of NA data
     */
    private final int NA_Y = 195;
    /**
     * y-axis value of states' CFR 
     */
    private final int CFR_Y = 225;
    /**
     * x-axis value of the bars
     */
    private final int BAR_X = 150;
    /**
     * y-axis value of the bars
     */
    private final int BAR_Y = 205;
    /**
     * y-axis value of the title
     */
    private final int TITLE_Y = 15;
    private LinkedList<Race> races;
    private State[] states;

    /**
     * Constructor
     * 
     * @param calculator
     *            covid calculator param
     */
    public GUICovidWindow(CovidCalculator covid, State[] statesArray) {
        window = new Window();
        window.setTitle("Covid Calculator");
        calculator = covid;
        lastClicked = null;
        states = statesArray;

        // Initialize buttons
        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "sortAlpha");
        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "sortCFR");
        quit = new Button("Quit");
        quit.onClick(this, "quit");
        DC = new Button("Represent DC");
        DC.onClick(this, "clickDC");
        GA = new Button("Represent GA");
        GA.onClick(this, "clickGA");
        MD = new Button("Represent MD");
        MD.onClick(this, "clickMD");
        NC = new Button("Represent NC");
        NC.onClick(this, "clickNC");
        TN = new Button("Represent TN");
        TN.onClick(this, "clickTN");
        VA = new Button("Represent VA");
        VA.onClick(this, "clickVA");
        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);
        window.addButton(DC, WindowSide.SOUTH);
        window.addButton(GA, WindowSide.SOUTH);
        window.addButton(MD, WindowSide.SOUTH);
        window.addButton(NC, WindowSide.SOUTH);
        window.addButton(TN, WindowSide.SOUTH);
        window.addButton(VA, WindowSide.SOUTH);
    }

    /**
     * button that sort races alphabetically for each state
     * @param button
     *              sort by Alpha button
     */
    public void sortAlpha(Button button) {
        if (lastClicked == null) {

        }

        else if (lastClicked.equals(DC)) {
            calculator.sortAlpha("DC");
            clickDC(lastClicked);
        }

        else if (lastClicked.equals(GA)) {
            calculator.sortAlpha("GA");
            clickGA(lastClicked);
        }

        else if (lastClicked.equals(MD)) {
            calculator.sortAlpha("MD");
            clickMD(lastClicked);
        }

        else if (lastClicked.equals(NC)) {
            calculator.sortAlpha("NC");
            clickNC(lastClicked);
        }

        else if (lastClicked.equals(TN)) {
            calculator.sortAlpha("TN");
            clickTN(lastClicked);
        }

        else if (lastClicked.equals(VA)) {
            calculator.sortAlpha("VA");
            clickVA(lastClicked);
        }
    }
    
    /**
     * button that sort races by CFR for each state
     * @param button
     *              sort by CFR button
     */
    public void sortCFR(Button button) {
        if (lastClicked == null) {

        }

        else if (lastClicked.equals(DC)) {
            calculator.sortCFR("DC");
            clickDC(lastClicked);
        }

        else if (lastClicked.equals(GA)) {
            calculator.sortCFR("GA");
            clickGA(lastClicked);
        }

        else if (lastClicked.equals(MD)) {
            calculator.sortCFR("MD");
            clickMD(lastClicked);
        }

        else if (lastClicked.equals(NC)) {
            calculator.sortCFR("NC");
            clickNC(lastClicked);
        }

        else if (lastClicked.equals(TN)) {
            calculator.sortCFR("TN");
            clickTN(lastClicked);
        }

        else if (lastClicked.equals(VA)) {
            calculator.sortCFR("VA");
            clickVA(lastClicked);
        }
    }


    /**
     * This method quits the program
     * 
     * @param button
     *            quits the program
     */
    public void quit(Button button) {
        System.exit(0);
    }


    /**
     * The method that will show the statistic for DC
     * when click Represent VA
     * 
     * @param button
     *            Represent DC button
     */
    public void clickDC(Button button) {
        lastClicked = button;
        window.removeAllShapes();

        for (State DC : states) {

            if (DC.getName().equals("DC")) {
                races = DC.getRaceList();

                TextShape title = new TextShape(0, 0,
                    "DC Case Fatality Ratio by Race");
                title.setX(window.getGraphPanelWidth()/2 - title.getWidth()/2);
                title.setY(TITLE_Y);

                window.addShape(title);

                updateBars(DC);
            }
        }
    }


    /**
     * The method that will show the statistic for GA
     * when click Represent GA
     * 
     * @param button
     *            Represent GA button
     */
    public void clickGA(Button button) {
        lastClicked = button;
        window.removeAllShapes();

        for (State GA : states) {

            if (GA.getName().equals("GA")) {
                races = GA.getRaceList();

                TextShape title = new TextShape(0, 0,
                    "GA Case Fatality Ratio by Race");
                title.setX(window.getGraphPanelWidth()/2 - title.getWidth()/2);
                title.setY(TITLE_Y);

                window.addShape(title);

                updateBars(GA);
            }
        }
    }


    /**
     * The method that will show the statistic for MD
     * when click Represent MD
     * 
     * @param button
     *            Represent MD button
     */
    public void clickMD(Button button) {
        lastClicked = button;
        window.removeAllShapes();

        for (State MD : states) {

            if (MD.getName().equals("MD")) {
                races = MD.getRaceList();

                TextShape title = new TextShape(0, 0,
                    "MD Case Fatality Ratio by Race");
                title.setX(window.getGraphPanelWidth()/2 - title.getWidth()/2);
                title.setY(TITLE_Y);

                window.addShape(title);

                updateBars(MD);
            }
        }
    }


    /**
     * The method that will show the statistic for NC
     * when click Represent NC
     * 
     * @param button
     *            Represent NC button
     */
    public void clickNC(Button button) {
        lastClicked = button;
        window.removeAllShapes();

        for (State NC : states) {

            if (NC.getName().equals("NC")) {
                races = NC.getRaceList();

                TextShape title = new TextShape(0, 0,
                    "NC Case Fatality Ratio by Race");
                title.setX(window.getGraphPanelWidth()/2 - title.getWidth()/2);
                title.setY(TITLE_Y);

                window.addShape(title);

                updateBars(NC);
            }
        }
    }


    /**
     * The method that will show the statistic for TN
     * when click Represent TN
     * 
     * @param button
     *            Represent TN button
     */
    public void clickTN(Button button) {
        lastClicked = button;
        window.removeAllShapes();

        for (State TN : states) {

            if (TN.getName().equals("TN")) {
                races = TN.getRaceList();

                TextShape title = new TextShape(0, 0,
                    "TN Case Fatality Ratio by Race");
                title.setX(window.getGraphPanelWidth()/2 - title.getWidth()/2);
                title.setY(TITLE_Y);

                window.addShape(title);

                updateBars(TN);
            }
        }
    }


    /**
     * The method that will show the statistic for VA
     * when click Represent VA
     * 
     * @param button
     *            Represent VA button
     */
    public void clickVA(Button button) {
        lastClicked = button;
        window.removeAllShapes();

        for (State VA : states) {

            if (VA.getName().equals("VA")) {
                races = VA.getRaceList();

                TextShape title = new TextShape(0, 0,
                    "VA Case Fatality Ratio by Race");
                title.setX(window.getGraphPanelWidth()/2 - title.getWidth()/2);
                title.setY(TITLE_Y);

                window.addShape(title);

                updateBars(VA);
            }
        }
    }


    /**
     * Update bars that represent the statistic for each states
     * 
     * @param state
     *            state that will be updated
     */
    private void updateBars(State state) {
        LinkedList<Shape> shapeList = new LinkedList<Shape>();

        for (int i = 0; i < state.getRaceList().size(); i++) {
            double cfr = state.getRaceList().get(i).getCFR();
            int barHeight = (int)(cfr * 10);

            Shape shape = new Shape((BAR_X + (BAR_GAP_FACTOR * i)) + BAR_CENTER, BAR_Y - (barHeight), BAR_WIDTH,
                (barHeight));
            shape.setBackgroundColor(Color.BLUE);
            shape.setForegroundColor(Color.BLUE);
            shapeList.add(shape);

            TextShape textRace = new TextShape((BAR_X + (BAR_GAP_FACTOR * i)), RACE_Y, races
                .get(i).getName());
            window.addShape(textRace);

            if (cfr < 0) {
                TextShape textNA = new TextShape((BAR_X + (BAR_GAP_FACTOR * i)) + NA_CENTER, NA_Y, "NA");
                window.addShape(textNA);

            }
            else {
                TextShape CFR = new TextShape((BAR_X + (BAR_GAP_FACTOR * i)), CFR_Y, "" + cfr
                    + "%");
                window.addShape(CFR);
            }
            window.addShape(shapeList.get(i));

        }
    }

}
