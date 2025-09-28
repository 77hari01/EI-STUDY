package Marsrover.terrain;
import Marsrover.value.Position;

class WaterSource extends TerrainComponent {
    public WaterSource(String name, Position position) {
        super(name, position);
    }

    @Override
    public String getDescription() {
        return "Water Source: " + name + " at " + position;
    }
}
