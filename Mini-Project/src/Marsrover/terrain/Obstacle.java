package Marsrover.terrain;
import Marsrover.value.Position;

class Obstacle extends TerrainComponent {
    public Obstacle(String name, Position position) {
        super(name, position);
    }

    @Override
    public String getDescription() {
        return "Obstacle: " + name + " at " + position;
    }
}