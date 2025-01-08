package Commands;

import bike_simulation_bgl_jason_li.BikeSimulator;

public class TurnRightCommand implements Command {

	@Override
	public void execute(BikeSimulator simulator) {
		// TODO Auto-generated method stub
		simulator.turnRight();
	}

}
