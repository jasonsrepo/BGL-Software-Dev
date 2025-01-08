package bike_simulation_bgl_jason_li;

public class Position {

	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Position move(Direction direction) {
		return new Position(
				x + direction.getDx(),
				y + direction.getDy()
			);
		
	}
	
	@Override
	public String toString() {
		return String.format("%d, %d)", x, y);
	}
}
