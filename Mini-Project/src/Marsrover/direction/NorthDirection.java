package Marsrover.direction;
import Marsrover.value.Position;

public class NorthDirection extends Direction {
    public NorthDirection() { super("N"); }

    @Override
    public Direction turnLeft() { return new WestDirection(); }

    @Override
    public Direction turnRight() { return new EastDirection(); }

    @Override
    public Position getNextPosition(Position current) {
        return new Position(current.getX(), current.getY() + 1);
    }
}
