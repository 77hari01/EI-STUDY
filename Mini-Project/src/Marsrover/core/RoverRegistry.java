package Marsrover.core;

import java.util.HashMap;
import java.util.Map;

public class RoverRegistry {
    private static RoverRegistry instance;
    private Map<String, Rover> rovers;

    private RoverRegistry() {
        rovers = new HashMap<>();
    }

    public static RoverRegistry getInstance() {
        if (instance == null) {
            synchronized (RoverRegistry.class) {
                if (instance == null) {
                    instance = new RoverRegistry();
                }
            }
        }
        return instance;
    }

    public void registerRover(Rover rover) {
        rovers.put(rover.getName().toLowerCase(), rover);
    }

    public Rover findRover(String name) {
        return rovers.get(name.toLowerCase());
    }

    public Map<String, Rover> getAllRovers() {
        return new HashMap<>(rovers);
    }

    public boolean hasRover(String name) {
        return rovers.containsKey(name.toLowerCase());
    }
}