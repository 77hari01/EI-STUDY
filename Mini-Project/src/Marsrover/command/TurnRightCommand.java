package Marsrover.command;

import Marsrover.core.Rover;

class TurnRightCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        rover.turnRight();
        return true;
    }
}