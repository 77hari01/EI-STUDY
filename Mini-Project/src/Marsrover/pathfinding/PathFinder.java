package Marsrover.pathfinding;
import Marsrover.core.Grid;
import Marsrover.value.Position;

import java.util.*;

public class PathFinder {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static List<Position> findPath(Position start, Position destination, Grid grid) {
        Set<Position> openSet = new HashSet<>();
        Set<Position> closedSet = new HashSet<>();
        Map<Position, PathNode> allNodes = new HashMap<>();

        PathNode startNode = new PathNode(start, null);
        startNode.calculateCosts(start, destination);
        allNodes.put(start, startNode);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Position current = getLowestFCostPosition(openSet, allNodes);
            openSet.remove(current);
            closedSet.add(current);

            if (current.equals(destination)) {
                return reconstructPath(allNodes.get(current));
            }

            for (int[] direction : DIRECTIONS) {
                Position neighbor = new Position(
                        current.getX() + direction[0],
                        current.getY() + direction[1]
                );

                if (!grid.isValidPosition(neighbor) ||
                        grid.hasObstacle(neighbor) ||
                        closedSet.contains(neighbor)) {
                    continue;
                }

                PathNode currentNode = allNodes.get(current);
                int tentativeGCost = currentNode.getGCost() + 1;

                if (!openSet.contains(neighbor)) {
                    PathNode neighborNode = new PathNode(neighbor, currentNode);
                    neighborNode.setGCost(tentativeGCost);
                    neighborNode.calculateCosts(start, destination);
                    allNodes.put(neighbor, neighborNode);
                    openSet.add(neighbor);
                } else {
                    PathNode neighborNode = allNodes.get(neighbor);
                    if (tentativeGCost < neighborNode.getGCost()) {
                        neighborNode = new PathNode(neighbor, currentNode);
                        neighborNode.setGCost(tentativeGCost);
                        neighborNode.calculateCosts(start, destination);
                        allNodes.put(neighbor, neighborNode);
                    }
                }
            }
        }

        return new ArrayList<>(); // No path found
    }

    private static Position getLowestFCostPosition(Set<Position> openSet, Map<Position, PathNode> allNodes) {
        Position lowest = null;
        int lowestFCost = Integer.MAX_VALUE;

        for (Position pos : openSet) {
            PathNode node = allNodes.get(pos);
            if (node.getFCost() < lowestFCost) {
                lowestFCost = node.getFCost();
                lowest = pos;
            }
        }

        return lowest;
    }

    private static List<Position> reconstructPath(PathNode endNode) {
        List<Position> path = new ArrayList<>();
        PathNode current = endNode;

        while (current != null) {
            path.add(0, current.getPosition());
            current = current.getParent();
        }

        return path;
    }
}