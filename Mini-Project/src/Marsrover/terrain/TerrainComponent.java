package Marsrover.terrain;
import Marsrover.value.Position;

abstract class TerrainComponent {
    protected String name;
    protected Position position;

    public TerrainComponent(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public abstract String getDescription();
    public Position getPosition() { return position; }
    public String getName() { return name; }
}
