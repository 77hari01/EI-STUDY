package Marsrover.decorator;
import Marsrover.core.Rover;
import Marsrover.pathfinding.PathFinder;
import Marsrover.value.Position;

import java.util.List;

public class WaterDetectorRover extends RoverDecorator {
    public WaterDetectorRover(Rover rover) {
        super(rover);
    }

    @Override
    public boolean move() {
        boolean moved = super.move();
        if (moved && rover.getGrid().hasWater(rover.getPosition())) {
            rover.notifyWaterFound();
        }
        return moved;
    }

    @Override
    public boolean navigateToDestination(Position destination) {
        if (!rover.getGrid().isValidPosition(destination)) {
            System.out.println("Invalid destination: " + destination);
            return false;
        }

        if (rover.getGrid().hasObstacle(destination)) {
            System.out.println("Cannot reach destination - obstacle at " + destination);
            return false;
        }

        if (rover.getPosition().equals(destination)) {
            System.out.println("Already at destination " + destination);
            rover.notifyDestinationReached(destination);
            return true;
        }

        rover.notifyPathfindingStarted(rover.getPosition(), destination);

        List<Position> path = PathFinder.findPath(rover.getPosition(), destination, rover.getGrid());

        if (path.isEmpty()) {
            System.out.println("No path found to destination " + destination);
            return false;
        }

        rover.notifyPathfindingCompleted(path);

        // Execute the path with water detection enabled
        for (int i = 1; i < path.size(); i++) {
            Position targetPosition = path.get(i);

            // Check for water at current position before moving
            if (rover.getGrid().hasWater(rover.getPosition())) {
                rover.notifyWaterFound();
            }

            if (!rover.moveToAdjacentPosition(targetPosition)) {
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

        // Check for water at final destination
        if (rover.getGrid().hasWater(rover.getPosition())) {
            rover.notifyWaterFound();
        }

        rover.notifyDestinationReached(destination);
        return true;
    }

    @Override
    public String getStatusReport() {
        String baseReport = super.getStatusReport();
        return baseReport + " [WATER DETECTOR ENABLED]";
    }
}
