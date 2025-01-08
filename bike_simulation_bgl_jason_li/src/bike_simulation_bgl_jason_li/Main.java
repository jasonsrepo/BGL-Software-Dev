package bike_simulation_bgl_jason_li;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BikeSimulator simulator = new BikeSimulator(7, 7);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Bike Simulation!");
        System.out.println("Available commands:");
        System.out.println("- PLACE X,Y,DIRECTION (e.g., PLACE 0,0,NORTH)");
        System.out.println("- FORWARD");
        System.out.println("- TURN_LEFT");
        System.out.println("- TURN_RIGHT");
        System.out.println("- GPS_REPORT");
        System.out.println("(press Ctrl+C to exit):\n");
        
        System.out.print("Enter Command > ");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            simulator.executeCommand(command);
            System.out.print("Enter Command > ");
        }
	}

}
