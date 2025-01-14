package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import bike_simulation_bgl_jason_li.Simulator.BikeSimulator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JUnitTest {

	private BikeSimulator simulator;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUp() {
        simulator = new BikeSimulator(7, 7);
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    private String getLastLine() {
        String[] lines = outputStream.toString().split("\n");
        return lines.length > 0 ? lines[lines.length - 1].trim() : "";
    }
    
    @Test
    @DisplayName("ExampleTest1 Basic forward command")
    void testBasicForwardCommand() {
        simulator.executeCommand("PLACE 0,5,NORTH");
        simulator.executeCommand("FORWARD");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("(0,6), NORTH", getLastLine());
    }

    @Test
    @DisplayName("ExampleTest2 Basic turn command")
    void testBasicTurnCommand() {
        simulator.executeCommand("PLACE 0,0,NORTH");
        simulator.executeCommand("TURN_LEFT");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("(0,0), WEST", getLastLine());
    }

    @Test
    @DisplayName("ExampleTest3 Complex movements")
    void testComplexMovements() {
        simulator.executeCommand("PLACE 1,2,EAST");
        simulator.executeCommand("FORWARD");
        simulator.executeCommand("FORWARD");
        simulator.executeCommand("TURN_LEFT");
        simulator.executeCommand("FORWARD");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("(3,3), NORTH", getLastLine());
    }

    @Test
    @DisplayName("Grid Boundary")
    void testGridBoundary() {
        simulator.executeCommand("PLACE 0,0,WEST");
        simulator.executeCommand("FORWARD");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("(0,0), WEST", getLastLine());
    }

    @Test
    @DisplayName("Multiple Turns")
    void testMultipleTurns() {
        simulator.executeCommand("PLACE 2,2,NORTH");
        simulator.executeCommand("TURN_RIGHT");
        simulator.executeCommand("TURN_RIGHT");
        simulator.executeCommand("TURN_RIGHT");
        simulator.executeCommand("TURN_LEFT");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("(2,2), SOUTH", getLastLine());
    }

    @Test
    @DisplayName("Invalid Placement")
    void testInvalidPlacement() {
        simulator.executeCommand("PLACE 8,8,NORTH");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("Bike not placed yet!", getLastLine());
    }

    @Test
    @DisplayName("Commands Before Placement")
    void testCommandsBeforePlacement() {
        simulator.executeCommand("FORWARD");
        simulator.executeCommand("TURN_LEFT");
        simulator.executeCommand("PLACE 1,1,NORTH");
        simulator.executeCommand("GPS_REPORT");
        
        assertEquals("(1,1), NORTH", getLastLine());
    }
}
