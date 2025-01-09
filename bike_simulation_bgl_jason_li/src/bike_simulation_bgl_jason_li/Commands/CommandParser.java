package bike_simulation_bgl_jason_li.Commands;

import bike_simulation_bgl_jason_li.model.Direction;

public class CommandParser {
	public static Command parseCommand(String input) {
		if (input == null || input.trim().isEmpty()) {
			return null;
		}
		
		String[] parts = input.trim().split("\\s+", 2);
		String commandType = parts[0].toUpperCase();
		
		try {
			switch (commandType) {
			case "PLACE":
				if (parts.length < 2) {
					return null;
				}
				return parsePlaceCommand(parts[1]);
			case "FORWARD":
				return new ForwardCommand();
			case "TURN_LEFT":
				return new TurnLeftCommand();
			case "TURN_RIGHT":
				return new TurnRightCommand();
			case "GPS_REPORT":
				return new GPSReportCommand();
			default:
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	private static Command parsePlaceCommand(String arguments) {
		String[] parts = arguments.split(",");
        if (parts.length != 3) {
        	return null;
        }

        try {
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            Direction direction = Direction.valueOf(parts[2].trim().toUpperCase());
            return new PlaceCommand(x, y, direction);
        } catch (Exception e) {
            return null;
        }
	}
}
