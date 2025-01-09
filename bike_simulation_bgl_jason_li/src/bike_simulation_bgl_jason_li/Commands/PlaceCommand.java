package bike_simulation_bgl_jason_li.Commands;

import bike_simulation_bgl_jason_li.Model.Direction;
import bike_simulation_bgl_jason_li.Model.Position;
import bike_simulation_bgl_jason_li.Simulator.BikeSimulator;

public class PlaceCommand implements Command {
	
	private final Position position;
	private final Direction direction;
	
	public PlaceCommand(int x, int y, Direction direction) {
		this.position = new Position(x,y);
		this.direction = direction;
	}

	@Override
	public void execute(BikeSimulator simulator) {
		// TODO Auto-generated method stub
		simulator.place(position, direction);
	}

}
