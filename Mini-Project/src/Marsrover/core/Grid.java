package Marsrover.core;

import java.util.HashSet;
import java.util.Set;
import Marsrover.value.Position;

public class Grid {
    private final int width, height;
    private final Set<Position> obstacles;
    private final Set<Position> waterPositions;

    public Grid(int width, int height, Set<Position> obstacles, Set<Position> waterPositions) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>(obstacles);
        this.waterPositions = new HashSet<>(waterPositions);
    }

    public boolean isValidPosition(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
    }

    public boolean hasObstacle(Position position) {
        return obstacles.contains(position);
    }

    public boolean hasWater(Position position) {
        return waterPositions.contains(position);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}