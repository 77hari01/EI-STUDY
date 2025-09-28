package Marsrover.direction;

public class DirectionFactory {
    public static Direction createDirection(String direction) {
        switch (direction.toUpperCase()) {
            case "N": return new NorthDirection();
            case "S": return new SouthDirection();
            case "E": return new EastDirection();
            case "W": return new WestDirection();
            default: throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}