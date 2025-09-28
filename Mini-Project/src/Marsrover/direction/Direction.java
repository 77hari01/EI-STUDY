package Marsrover.direction;
import Marsrover.value.Position;

public abstract class Direction {
    protected String name;

    public Direction(String name) {
        this.name = name;
    }

    public abstract Direction turnLeft();
    public abstract Direction turnRight();
    public abstract Position getNextPosition(Position current);
    public String getName() { return name; }
}