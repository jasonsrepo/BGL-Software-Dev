package bike_simulation_bgl_jason_li.Commands;

import bike_simulation_bgl_jason_li.Simulator.BikeSimulator;

public interface Command {
	void execute(BikeSimulator simulator);
}
