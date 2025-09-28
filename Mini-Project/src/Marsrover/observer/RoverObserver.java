package Marsrover.observer;

import java.util.List;

import Marsrover.direction.Direction;
import Marsrover.value.Position;

public interface RoverObserver {
    void onRoverMoved(String roverName, Position oldPosition, Position newPosition);
    void onRoverTurned(String roverName, Direction newDirection);
    void onObstacleDetected(String roverName, Position obstaclePosition);
    void onWaterFound(String roverName, Position waterPosition);
    void onPathfindingStarted(String roverName, Position start, Position destination);
    void onPathfindingCompleted(String roverName, List<Position> path);
    void onDestinationReached(String roverName, Position destination);
}
