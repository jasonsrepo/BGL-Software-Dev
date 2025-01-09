package bike_simulation_bgl_jason_li;

import Commands.Command;
import Commands.CommandParser;
import Commands.PlaceCommand;

public class BikeSimulator {
	private final Grid grid;
	private final Bike bike;
	
	public BikeSimulator(int width, int height) {
		this.grid = new Grid(width, height);
		this.bike = new Bike();
	}
	
	public void place(Position position, Direction direction) {
		if (grid.isValidPosition(position)) {
			bike.place(position, direction);
			System.out.println("Bike placed at position (" + position.getX() + "," + position.getY() + ") facing " + direction);
		}
		else {
			System.out.println("Cannot place bike at (" + position.getX() + "," + position.getY() + "): Position is outside the grid!");
		}
	}
	
	public void moveForward() {
		if (!bike.isPlaced()) {
			return;
		}
		
		Position newPosition = bike.getPosition().move(bike.getDirection());
		
		if (grid.isValidPosition(newPosition)) {
			bike.place(newPosition,  bike.getDirection());
			System.out.println("Bike moved forward");
		}
		else {
			System.out.println("Bike cannot move forward");
		}
		
	}
	
	public void turnLeft() {
		if (!bike.isPlaced()) {
			return;
		}
		
		Direction oldDirection = bike.getDirection();
        Direction newDirection = oldDirection.turnLeft();
        
        bike.place(bike.getPosition(), newDirection);
        System.out.println("Bike turned left from " + oldDirection + " to " + newDirection);
    }

    public void turnRight() {
    	if (!bike.isPlaced()) {
			return;
		}
    	
    	Direction oldDirection = bike.getDirection();
        Direction newDirection = oldDirection.turnRight();
        bike.place(bike.getPosition(), newDirection);
        System.out.println("Bike turned right from " + oldDirection + " to " + newDirection);
    }
    
    public void reportPosition() {
        if (bike.isPlaced()) {
            System.out.println(bike);
        }
    }
    
    public void executeCommand(String input) {
    	Command command = CommandParser.parseCommand(input);
    	
    	if (command != null) {
    		if (bike.isPlaced() || command instanceof PlaceCommand) {
    			command.execute(this);
    		} else {
        		System.out.println("Bike not placed yet!");
    		}
    	}
    	else {
    		System.out.println("Please enter valid commands.");
    	}
    }

}
