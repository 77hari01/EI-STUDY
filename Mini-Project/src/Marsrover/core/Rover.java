package Marsrover.core;

import Marsrover.command.Command;
import Marsrover.command.CommandFactory;
import Marsrover.observer.RoverObserver;
import Marsrover.direction.*;
import Marsrover.pathfinding.PathFinder;
import Marsrover.value.Position;
import java.util.ArrayList;
import java.util.List;

public class Rover {
    private String name;
    private Position position;
    private Direction direction;
    private Grid grid;
    private List<RoverObserver> observers;

    public Rover(String name, Position startPosition, Direction direction, Grid grid) {
        this.name = name;
        this.position = startPosition;
        this.direction = direction;
        this.grid = grid;
        this.observers = new ArrayList<>();
    }

    public boolean move() {
        Position nextPosition = direction.getNextPosition(position);

        if (!grid.isValidPosition(nextPosition)) {
            System.out.println(name + " cannot move - boundary limit reached!");
            return false;
        }

        if (grid.hasObstacle(nextPosition)) {
            notifyObstacleDetected(nextPosition);
            return false;
        }

        Position oldPosition = position;
        position = nextPosition;
        notifyMoved(oldPosition, position);
        return true;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
        notifyTurned();
    }

    public void turnRight() {
        direction = direction.turnRight();
        notifyTurned();
    }

    public void executeCommands(String commands) {
        for (char cmdChar : commands.toCharArray()) {
            try {
                Command command = CommandFactory.createCommand(cmdChar);
                command.execute(this);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid command: " + cmdChar);
            }
        }
    }

    public boolean navigateToDestination(Position destination) {
        if (!grid.isValidPosition(destination)) {
            System.out.println("Invalid destination: " + destination);
            return false;
        }

        if (grid.hasObstacle(destination)) {
            System.out.println("Cannot reach destination - obstacle at " + destination);
            return false;
        }

        if (position.equals(destination)) {
            System.out.println("Already at destination " + destination);
            notifyDestinationReached(destination);
            return true;
        }

        notifyPathfindingStarted(position, destination);

        List<Position> path = PathFinder.findPath(position, destination, grid);

        if (path.isEmpty()) {
            System.out.println("No path found to destination " + destination);
            return false;
        }

        notifyPathfindingCompleted(path);

        // Execute the path (skip first position as it's current position)
        for (int i = 1; i < path.size(); i++) {
            Position targetPosition = path.get(i);

            if (!moveToAdjacentPosition(targetPosition)) {
                System.out.println("Failed to move to " + targetPosition);
                return false;
            }

            // Small delay for better visualization
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        notifyDestinationReached(destination);
        return true;
    }

    public boolean moveToAdjacentPosition(Position target) {
        Position current = this.position;

        // Calculate required direction
        int deltaX = target.getX() - current.getX();
        int deltaY = target.getY() - current.getY();

        Direction requiredDirection = null;
        if (deltaX == 1 && deltaY == 0) requiredDirection = new EastDirection();
        else if (deltaX == -1 && deltaY == 0) requiredDirection = new WestDirection();
        else if (deltaX == 0 && deltaY == 1) requiredDirection = new NorthDirection();
        else if (deltaX == 0 && deltaY == -1) requiredDirection = new SouthDirection();

        if (requiredDirection == null) {
            System.out.println("Cannot move to non-adjacent position: " + target);
            return false;
        }

        // Turn to face the required direction
        while (!direction.getName().equals(requiredDirection.getName())) {
            turnRight(); // Simple turning logic
        }

        // Move forward
        return move();
    }

    public String getStatusReport() {
        return String.format("Rover: %s | Position: %s | Direction: %s",
                name, position, direction.getName());
    }

    // Observer methods
    public void addObserver(RoverObserver observer) {
        observers.add(observer);
    }

    private void notifyMoved(Position oldPos, Position newPos) {
        for (RoverObserver observer : observers) {
            observer.onRoverMoved(name, oldPos, newPos);
        }
    }

    private void notifyTurned() {
        for (RoverObserver observer : observers) {
            observer.onRoverTurned(name, direction);
        }
    }

    private void notifyObstacleDetected(Position obstaclePos) {
        for (RoverObserver observer : observers) {
            observer.onObstacleDetected(name, obstaclePos);
        }
    }

    public void notifyWaterFound() {
        for (RoverObserver observer : observers) {
            observer.onWaterFound(name, position);
        }
    }

    public void notifyPathfindingStarted(Position start, Position destination) {
        for (RoverObserver observer : observers) {
            observer.onPathfindingStarted(name, start, destination);
        }
    }

    public void notifyPathfindingCompleted(List<Position> path) {
        for (RoverObserver observer : observers) {
            observer.onPathfindingCompleted(name, path);
        }
    }

    public void notifyDestinationReached(Position destination) {
        for (RoverObserver observer : observers) {
            observer.onDestinationReached(name, destination);
        }
    }

    // Getters
    public String getName() { return name; }
    public Position getPosition() { return position; }
    public Direction getDirection() { return direction; }
    public Grid getGrid() { return grid; }
}
