package bike_simulation_bgl_jason_li;

public class Bike {
	private Position position;
	private Direction direction;
	
	public void place(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public boolean isPlaced() {
		return position != null && direction != null;
	}
	
	@Override
	public String toString() {
		return String.format("(%d,%d), %s", position.getX(), position.getY(), direction);
	}
}
