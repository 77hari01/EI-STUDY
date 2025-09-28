package Marsrover.direction;
import Marsrover.value.Position;

public class SouthDirection extends Direction {
    public SouthDirection() { super("S"); }

    @Override
    public Direction turnLeft() { return new EastDirection(); }

    @Override
    public Direction turnRight() { return new WestDirection(); }

    @Override
    public Position getNextPosition(Position current) {
        return new Position(current.getX(), current.getY() - 1);
    }
}
