package Marsrover.direction;
import Marsrover.value.Position;

public class EastDirection extends Direction {
    public EastDirection() { super("E"); }

    @Override
    public Direction turnLeft() { return new NorthDirection(); }

    @Override
    public Direction turnRight() { return new SouthDirection(); }

    @Override
    public Position getNextPosition(Position current) {
        return new Position(current.getX() + 1, current.getY());
    }
}
