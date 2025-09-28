package Marsrover.terrain;

import java.util.ArrayList;
import java.util.List;

class TerrainComposite extends TerrainComponent {
    private List<TerrainComponent> components = new ArrayList<>();

    public TerrainComposite(String name) {
        super(name, null);
    }

    public void add(TerrainComponent component) {
        components.add(component);
    }

    public void remove(TerrainComponent component) {
        components.remove(component);
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Terrain Group: ").append(name).append("\n");
        for (TerrainComponent component : components) {
            sb.append("  - ").append(component.getDescription()).append("\n");
        }
        return sb.toString();
    }

    public List<TerrainComponent> getComponents() {
        return new ArrayList<>(components);
    }
}