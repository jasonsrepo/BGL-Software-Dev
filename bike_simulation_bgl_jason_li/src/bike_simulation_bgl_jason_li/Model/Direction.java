package bike_simulation_bgl_jason_li.Model;

public enum Direction {
	NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Direction turnLeft() {
        int ordinal = (this.ordinal() + 3) % 4;
        return Direction.values()[ordinal];
    }

    public Direction turnRight() {
        int ordinal = (this.ordinal() + 1) % 4;
        return Direction.values()[ordinal];
    }
}
