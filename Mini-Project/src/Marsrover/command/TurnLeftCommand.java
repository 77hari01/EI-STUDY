package Marsrover.command;

import Marsrover.core.Rover;

class TurnLeftCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        rover.turnLeft();
        return true;
    }
}
