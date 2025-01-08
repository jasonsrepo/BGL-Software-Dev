package Commands;

import bike_simulation_bgl_jason_li.BikeSimulator;

public class TurnLeftCommand implements Command {

	@Override
	public void execute(BikeSimulator simulator) {
		// TODO Auto-generated method stub
		simulator.turnLeft();
	}

}
