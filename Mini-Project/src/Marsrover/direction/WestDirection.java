package Marsrover.direction;
import Marsrover.value.Position;

public class WestDirection extends Direction {
    public WestDirection() { super("W"); }

    @Override
    public Direction turnLeft() { return new SouthDirection(); }

    @Override
    public Direction turnRight() { return new NorthDirection(); }

    @Override
    public Position getNextPosition(Position current) {
        return new Position(current.getX() - 1, current.getY());
    }
}