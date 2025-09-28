package Marsrover;

import Marsrover.core.Grid;
import Marsrover.core.Rover;
import Marsrover.core.RoverRegistry;
import Marsrover.observer.MissionControl;
import Marsrover.direction.Direction;
import Marsrover.direction.DirectionFactory;
import Marsrover.decorator.WaterDetectorRover;
import Marsrover.value.Position;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MarsRoverSimulation {
    private static Scanner scanner = new Scanner(System.in);
    private static RoverRegistry registry = RoverRegistry.getInstance();
    private static MissionControl missionControl = new MissionControl();

    public static void main(String[] args) {
        System.out.println(" Mars Rover Mission Control System ");
        System.out.println("=====================================");

        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    createRover();
                    break;
                case 2:
                    continueWithExistingRover();
                    break;
                case 3:
                    reachDestination();
                    break;
                case 4:
                    showStatusReport();
                    break;
                case 5:
                    System.out.println("Mission Control shutting down... ");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n==========MISSION MENU==========");
        System.out.println("1. Create New Rover");
        System.out.println("2. Continue with Existing Rover");
        System.out.println("3. Navigate to Destination");
        System.out.println("4. Status Report");
        System.out.println("5. Exit Mission");
        System.out.println("==================================");
    }

    private static void createRover() {
        System.out.println("\n--- Creating New Rover ---");

        String name = getStringInput("Enter rover name: ");
        if (registry.hasRover(name)) {
            System.out.println("Rover with name '" + name + "' already exists!");
            return;
        }

        int gridWidth = getIntInput("Enter grid width: ");
        int gridHeight = getIntInput("Enter grid height: ");

        int startX = getIntInput("Enter starting X position: ");
        int startY = getIntInput("Enter starting Y position: ");
        Position startPosition = new Position(startX, startY);

        String directionStr = getStringInput("Enter starting direction (N/S/E/W): ");
        Direction direction = DirectionFactory.createDirection(directionStr);

        // Get obstacles
        Set<Position> obstacles = getObstacles();

        // Get water positions
        Set<Position> waterPositions = getWaterPositions();

        Grid grid = new Grid(gridWidth, gridHeight, obstacles, waterPositions);

        if (!grid.isValidPosition(startPosition)) {
            System.out.println("Invalid starting position! Must be within grid boundaries.");
            return;
        }

        if (grid.hasObstacle(startPosition)) {
            System.out.println("Cannot start at obstacle position!");
            return;
        }

        Rover baseRover = new Rover(name, startPosition, direction, grid);

        // Add water detector capability
        Rover finalRover = baseRover;
        boolean addWaterDetector = getBooleanInput("Add water detection capability? (y/n): ");
        if (addWaterDetector) {
            finalRover = new WaterDetectorRover(baseRover);
        }

        finalRover.addObserver(missionControl);
        registry.registerRover(finalRover);

        System.out.println("Rover '" + name + "' created successfully!");
        System.out.println(finalRover.getStatusReport());

        // Execute initial commands
        String commands = getStringInput("Enter initial commands (M/L/R) or press Enter to skip: ");
        if (!commands.trim().isEmpty()) {
            finalRover.executeCommands(commands);
        }
    }

    private static void continueWithExistingRover() {
        System.out.println("\n--- Continue with Existing Rover ---");

        String name = getStringInput("Enter rover name: ");
        Rover rover = registry.findRover(name);

        if (rover == null) {
            System.out.println("Rover '" + name + "' not found!");
            return;
        }

        System.out.println("Found rover: " + rover.getStatusReport());

        String commands = getStringInput("Enter commands (M/L/R): ");
        rover.executeCommands(commands);

        System.out.println("Updated status: " + rover.getStatusReport());
    }

    private static void reachDestination() {
        System.out.println("\n--- Navigate to Destination ---");

        String name = getStringInput("Enter rover name: ");
        Rover rover = registry.findRover(name);

        if (rover == null) {
            System.out.println("Rover '" + name + "' not found!");
            return;
        }

        System.out.println("Found rover: " + rover.getStatusReport());

        int destX = getIntInput("Enter destination X coordinate: ");
        int destY = getIntInput("Enter destination Y coordinate: ");
        Position destination = new Position(destX, destY);

        System.out.println("Attempting to navigate from " + rover.getPosition() + " to " + destination);
        System.out.println("Pathfinding in progress...\n");

        boolean success = rover.navigateToDestination(destination);

        if (success) {
            System.out.println("\nMission accomplished! Rover successfully reached destination.");
            System.out.println("Final status: " + rover.getStatusReport());
        } else {
            System.out.println("\nMission failed. Could not reach destination.");
            System.out.println("Current status: " + rover.getStatusReport());
        }
    }

    private static void showStatusReport() {
        System.out.println("\n--- Status Report ---");

        Map<String, Rover> allRovers = registry.getAllRovers();
        if (allRovers.isEmpty()) {
            System.out.println("No rovers deployed yet.");
            return;
        }

        boolean showAll = getBooleanInput("Show all rovers? (y/n): ");

        if (showAll) {
            System.out.println("All Active Rovers:");
            System.out.println("====================");
            for (Rover rover : allRovers.values()) {
                System.out.println(" " + rover.getStatusReport());
            }
        } else {
            String name = getStringInput("Enter rover name: ");
            Rover rover = registry.findRover(name);

            if (rover != null) {
                System.out.println(" " + rover.getStatusReport());
            } else {
                System.out.println("Rover '" + name + "' not found!");
            }
        }
    }

    private static Set<Position> getObstacles() {
        Set<Position> obstacles = new HashSet<>();
        boolean addMore = getBooleanInput("Add obstacles? (y/n): ");

        while (addMore) {
            int x = getIntInput("Obstacle X position: ");
            int y = getIntInput("Obstacle Y position: ");
            obstacles.add(new Position(x, y));

            addMore = getBooleanInput("Add another obstacle? (y/n): ");
        }

        return obstacles;
    }

    private static Set<Position> getWaterPositions() {
        Set<Position> waterPositions = new HashSet<>();
        boolean addMore = getBooleanInput("Add water sources? (y/n): ");

        while (addMore) {
            int x = getIntInput("Water source X position: ");
            int y = getIntInput("Water source Y position: ");
            waterPositions.add(new Position(x, y));

            addMore = getBooleanInput("Add another water source? (y/n): ");
        }

        return waterPositions;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static boolean getBooleanInput(String prompt) {
        while (true) {
            String input = getStringInput(prompt).toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'.");
        }
    }
}