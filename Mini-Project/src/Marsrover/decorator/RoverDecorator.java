package Marsrover.decorator;

import Marsrover.core.Rover;
import Marsrover.observer.RoverObserver;
import Marsrover.direction.Direction;
import Marsrover.value.Position;

abstract class RoverDecorator extends Rover {
    protected Rover rover;

    public RoverDecorator(Rover rover) {
        super(rover.getName(), rover.getPosition(), rover.getDirection(), rover.getGrid());
        this.rover = rover;
    }

    public boolean move() { return rover.move(); }
    public void turnLeft() { rover.turnLeft(); }
    public void turnRight() { rover.turnRight(); }
    public Position getPosition() { return rover.getPosition(); }
    public Direction getDirection() { return rover.getDirection(); }
    public String getName() { return rover.getName(); }
    public String getStatusReport() { return rover.getStatusReport(); }
    public void addObserver(RoverObserver observer) { rover.addObserver(observer); }
    public boolean navigateToDestination(Position destination) { return rover.navigateToDestination(destination); }
}