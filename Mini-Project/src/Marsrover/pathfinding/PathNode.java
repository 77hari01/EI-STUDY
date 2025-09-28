package Marsrover.pathfinding;
import Marsrover.value.Position;

class PathNode {
    private Position position;
    private PathNode parent;
    private int gCost; // Distance from start
    private int hCost; // Distance to destination (heuristic)
    private int fCost; // Total cost

    public PathNode(Position position, PathNode parent) {
        this.position = position;
        this.parent = parent;
        this.gCost = 0;
        this.hCost = 0;
        this.fCost = 0;
    }

    public void calculateCosts(Position start, Position destination) {
        if (parent != null) {
            gCost = parent.getGCost() + 1;
        }
        hCost = Math.abs(position.getX() - destination.getX()) +
                Math.abs(position.getY() - destination.getY());
        fCost = gCost + hCost;
    }

    // Getters and setters
    public Position getPosition() { return position; }
    public PathNode getParent() { return parent; }
    public int getGCost() { return gCost; }
    public int getHCost() { return hCost; }
    public int getFCost() { return fCost; }
    public void setGCost(int gCost) { this.gCost = gCost; this.fCost = gCost + hCost; }
}
