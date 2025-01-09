package test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import bike_simulation_bgl_jason_li.Simulator.BikeSimulator;

public class BikeTest {
    private BikeSimulator simulator;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void setup() {
        simulator = new BikeSimulator(7, 7);
        System.setOut(new PrintStream(outputStream));
    }

    public void cleanup() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    public void runTest(String testName, String[] commands, String expectedFinalPosition) {
    	originalOut.println("\nRunning test: " + testName);
    	
        setup();
        
        for (String command : commands) {
            simulator.executeCommand(command);
        }
        
        simulator.executeCommand("GPS_REPORT");
        String output = outputStream.toString();
        String[] lines = output.split("\n");
        String actualPosition = lines[lines.length - 1].trim();
        
        cleanup();
        
        System.out.println("Expected: " + expectedFinalPosition);
        System.out.println("Actual: " + actualPosition);
        System.out.println("Test " + (expectedFinalPosition.equals(actualPosition) ? "PASSED" : "FAILED"));
        
    }

    public void runAllTests() {

    	runTest("ExampleTest1 Basic forward command",
            	new String[] {"PLACE 0,5,NORTH", "FORWARD"},
            	"(0,6), NORTH");
            
        runTest("ExampleTest2 Basic turn command",
                new String[]{"PLACE 0,0,NORTH", "TURN_LEFT"},
                "(0,0), WEST");
        
        runTest("ExampleTest3 Complex movements",
                new String[]{"PLACE 1,2,EAST", "FORWARD", "FORWARD", "TURN_LEFT", "FORWARD"},
                "(3,3), NORTH");
            
        runTest("Grid Boundary",
            new String[]{"PLACE 0,0,WEST", "FORWARD"},
            "(0,0), WEST");

        runTest("Multiple Turns",
            new String[]{"PLACE 2,2,NORTH", "TURN_RIGHT", "TURN_RIGHT", "TURN_RIGHT", "TURN_LEFT"},
            "(2,2), SOUTH");

        runTest("Invalid Placement",
            new String[]{"PLACE 8,8,NORTH"},
            "Bike not placed yet!");

        runTest("Commands Before Placement",
            new String[]{"FORWARD", "TURN_LEFT", "PLACE 1,1,NORTH"},
            "(1,1), NORTH");
        
    }

    public static void main(String[] args) {
        BikeTest test = new BikeTest();
        test.runAllTests();
    }
}