package Marsrover.observer;

import java.util.List;

import Marsrover.direction.Direction;
import Marsrover.value.Position;

public class MissionControl implements RoverObserver {
    @Override
    public void onRoverMoved(String roverName, Position oldPosition, Position newPosition) {
        System.out.println("[MISSION CONTROL] " + roverName + " moved from " + oldPosition + " to " + newPosition);
    }

    @Override
    public void onRoverTurned(String roverName, Direction newDirection) {
        System.out.println("[MISSION CONTROL] " + roverName + " turned to face " + newDirection.getName());
    }

    @Override
    public void onObstacleDetected(String roverName, Position obstaclePosition) {
        System.out.println("[MISSION CONTROL] " + roverName + " detected obstacle at " + obstaclePosition);
    }

    @Override
    public void onWaterFound(String roverName, Position waterPosition) {
        System.out.println("[MISSION CONTROL]  " + roverName + " found WATER at " + waterPosition );
    }

    @Override
    public void onPathfindingStarted(String roverName, Position start, Position destination) {
        System.out.println("[MISSION CONTROL] " + roverName + " calculating path from " + start + " to " + destination);
    }

    @Override
    public void onPathfindingCompleted(String roverName, List<Position> path) {
        System.out.println("[MISSION CONTROL]  Path calculated with " + path.size() + " waypoints");
        System.out.print("[MISSION CONTROL] Route: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" → ");
        }
        System.out.println();
    }

    @Override
    public void onDestinationReached(String roverName, Position destination) {
        System.out.println("[MISSION CONTROL] " + roverName + " successfully reached destination " + destination);
    }
}

