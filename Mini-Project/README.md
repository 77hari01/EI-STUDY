# Mars Rover Simulation

A sophisticated Mars Rover simulation system built with Java, demonstrating multiple design patterns and autonomous navigation capabilities.

## Overview

This project is a Mars Rover Control System that allows users to create, manage, and operate rovers navigating a grid-based Martian terrain. The system provides comprehensive control over rover operations including movement, rotation, obstacle avoidance, autonomous pathfinding, and water source detection. The application uses several design patterns, including Command, State, Factory, Observer, Decorator, Composite, and Singleton patterns, to ensure a scalable and maintainable architecture.
The simulation features intelligent A* pathfinding algorithm for autonomous navigation, real-time mission control monitoring, and modular rover capabilities that can be extended through decorator patterns. Rovers can detect obstacles, find optimal paths around them, and identify water sources during exploration missions.

## Design Patterns Implemented

### Command Pattern
Encapsulates rover actions as command objects for flexible execution and potential undo/redo functionality.

**Available Commands:**
- [`MoveCommand`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/command/MoveCommand.java): Moves the rover forward in its current direction
- [`TurnLeftCommand`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/command/TurnLeftCommand.java): Rotates the rover 90 degrees counter-clockwise
- [`TurnRightCommand`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/command/TurnRightCommand.java): Rotates the rover 90 degrees clockwise

### State Pattern
Manages directional states for the rover's orientation.

**Direction States:**
- [`NorthDirection`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/direction/NorthDirection.java): Facing north (positive Y)
- [`SouthDirection`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/direction/SouthDirection.java): Facing south (negative Y)
- [`EastDirection`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/direction/EastDirection.java): Facing east (positive X)
- [`WestDirection`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/direction/WestDirection.java): Facing west (negative X)

### Factory Pattern
Creates direction and command objects dynamically based on input.

**Factories:**
- [`DirectionFactory`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/direction/DirectionFactory.java): Creates direction objects from single-character input (N/S/E/W)
- [`CommandFactory`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/command/CommandFactory.java): Creates command objects from single-character input (M/L/R)

### Observer Pattern
Enables mission control to monitor rover activities in real-time.

**Observable Events:**
- Rover movement
- Directional changes
- Obstacle detection
- Water source discovery
- Pathfinding progress
- Destination reached

### Decorator Pattern
Adds capabilities to rovers without modifying the base class.

**Available Decorators:**
- [`WaterDetectorRover`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/decorator/WaterDetectorRover.java): Adds automatic water detection during navigation

### Composite Pattern
Organizes terrain features into hierarchical structures.

**Components:**
- [`Obstacle`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/terrain/Obstacle.java): Represents impassable terrain
- [`WaterSource`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/terrain/WaterSource.java): Represents water locations
- [`TerrainComposite`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/terrain/TerrainComposite.java): Groups multiple terrain features

### Singleton Pattern
Ensures single instance of the rover registry.

**Singleton Classes:**
- [`RoverRegistry`](https://github.com/77hari01/EI-STUDY/blob/master/Mini-Project/src/Marsrover/core/RoverRegistry.java): Maintains global registry of all deployed rovers

## Features

### Autonomous Navigation
- **A* Pathfinding Algorithm**: Finds optimal paths while avoiding obstacles
- **Automatic Orientation**: Rover automatically adjusts direction to follow paths
- **Real-time Pathfinding**: Calculates routes on-demand

### Water Detection
- Optional water detection capability
- Automatic notifications when water is found
- Mission control alerts for discoveries

### Mission Control Monitoring
- Real-time tracking of all rover activities
- Event notifications for critical actions
- Status reporting for individual or all rovers

### Grid-Based Terrain
- Customizable grid dimensions
- User-defined obstacle placement
- Water source positioning
- Boundary enforcement

### Command Execution
- Manual command sequences (M/L/R)
- Batch command processing
- Error handling for invalid commands

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (IntelliJ IDEA, Eclipse, etc.) or command line

### Installation

1. Clone or download the repository
   ```bash
   git clone https://github.com/77hari01/EI-STUDY
   ```
2. Navigate to the project directory
   ```bash
   cd Mini-Project/src/Marsrover
   ```
3. Compile the Java file:
   ```bash
   javac MarsRoverSimulation.java
   ```

### Running the Application

Execute the compiled program:
```bash
java MarsRoverSimulation
```

## Usage

### Main Menu Options

1. **Create New Rover**
    - Define grid dimensions
    - Set starting position and direction
    - Add obstacles and water sources
    - Optional water detection capability
    - Execute initial commands

2. **Continue with Existing Rover**
    - Select a previously created rover
    - Execute manual command sequences
    - View updated status

3. **Navigate to Destination**
    - Select a rover
    - Specify destination coordinates
    - Automatic pathfinding and navigation
    - Real-time progress updates

4. **Status Report**
    - View all active rovers
    - Check individual rover status
    - Current position and direction

5. **Exit Mission**
    - Safely shutdown the system

### Command Syntax

**Manual Commands:**
- `M` - Move forward one grid cell
- `L` - Turn left 90 degrees
- `R` - Turn right 90 degrees

**Example:** `MMRMLM` moves forward twice, turns right, moves, turns left, and moves again

### Input Format

**Creating a Rover:**
```
Enter rover name: Perseverance
Enter grid width: 10
Enter grid height: 10
Enter starting X position: 0
Enter starting Y position: 0
Enter starting direction (N/S/E/W): N
Add obstacles? (y/n): y
Obstacle X position: 2
Obstacle Y position: 2
Add another obstacle? (y/n): n
Add water sources? (y/n): y
Water source X position: 5
Water source Y position: 5
Add another water source? (y/n): n
Add water detection capability? (y/n): y
Enter initial commands (M/L/R) or press Enter to skip: MMM
```

**Navigating to Destination:**
```
Enter rover name: Perseverance
Enter destination X coordinate: 7
Enter destination Y coordinate: 8
```

## System Behavior

### Obstacle Handling
- Rovers cannot move through obstacles
- Pathfinding automatically avoids obstacles
- Mission control notified when obstacles block movement

### Boundary Detection
- Rovers cannot move outside grid boundaries
- Invalid positions rejected during creation
- Destination validation before pathfinding

### Path Execution
- Automatic orientation adjustments
- Step-by-step movement with 500ms delays
- Progress notifications to mission control

### Water Detection
- Automatic detection when equipped
- Checks at current position and destination
- Mission control alerts with water emoji

## Error Handling

The system handles:
- Invalid grid dimensions
- Out-of-bounds positions
- Obstacles at starting/destination points
- Non-existent rover names
- Invalid command characters
- Invalid direction inputs
- Unreachable destinations
- Invalid numeric inputs

## Example Session

```
 Mars Rover Mission Control System 
=====================================

========== MISSION MENU ==========
1. Create New Rover
2. Continue with Existing Rover
3. Navigate to Destination
4. Status Report
5. Exit Mission
==================================
Enter your choice: 1

--- Creating New Rover ---
Enter rover name: Curiosity
Enter grid width: 10
Enter grid height: 10
Enter starting X position: 0
Enter starting Y position: 0
Enter starting direction (N/S/E/W): N
Add obstacles? (y/n): y
Obstacle X position: 2
Obstacle Y position: 2
Add another obstacle? (y/n): n
Add water sources? (y/n): y
Water source X position: 5
Water source Y position: 5
Add another water source? (y/n): n
Add water detection capability? (y/n): y
Enter initial commands (M/L/R) or press Enter to skip: 

Rover 'Curiosity' created successfully!
Rover: Curiosity | Position: (0, 0) | Direction: N [WATER DETECTOR ENABLED]

========== MISSION MENU ==========
Enter your choice: 3

--- Navigate to Destination ---
Enter rover name: Curiosity
Enter destination X coordinate: 5
Enter destination Y coordinate: 5
Found rover: Rover: Curiosity | Position: (0, 0) | Direction: N [WATER DETECTOR ENABLED]
Attempting to navigate from (0, 0) to (5, 5)
Pathfinding in progress...

[MISSION CONTROL] Curiosity calculating path from (0, 0) to (5, 5)
[MISSION CONTROL] Path calculated with 11 waypoints
[MISSION CONTROL] Route: (0, 0) → (0, 1) → (0, 2) → (1, 2) → (1, 3) → (1, 4) → (1, 5) → (2, 5) → (3, 5) → (4, 5) → (5, 5)
[MISSION CONTROL] Curiosity moved from (0, 0) to (0, 1)
...
[MISSION CONTROL] Curiosity found WATER at (5, 5) 
[MISSION CONTROL] Curiosity successfully reached destination (5, 5)

Mission accomplished! Rover successfully reached destination.
Final status: Rover: Curiosity | Position: (5, 5) | Direction: E [WATER DETECTOR ENABLED]
```

## Architecture Highlights

### Extensibility
- Easy to add new command types
- Simple decorator addition for new capabilities
- Pluggable observer pattern for monitoring

### Maintainability
- Clear separation of concerns
- Single responsibility principle
- Factory methods for object creation

### Scalability
- Registry pattern for multiple rovers
- Thread-safe singleton implementation
- Efficient A* pathfinding algorithm

## Future Enhancements

Potential improvements:
- Terrain elevation mapping
- Battery/fuel management
- Sample collection capabilities
- Multi-rover coordination
- Graphical user interface
- Save/load mission states
- Advanced sensor simulations

## Technical Details

**Grid System:**
- Zero-indexed coordinates
- Origin at bottom-left (0,0)
- X-axis increases eastward
- Y-axis increases northward

**Pathfinding:**
- A* algorithm with Manhattan distance heuristic
- Considers obstacles and boundaries
- Optimal path generation

**Thread Safety:**
- Double-checked locking in Singleton
- Thread interruption handling

## Conclusion

This Mars Rover Simulation demonstrates professional software engineering practices through the implementation of multiple design patterns, creating a flexible, maintainable, and extensible system for simulating autonomous rover operations on Mars.
