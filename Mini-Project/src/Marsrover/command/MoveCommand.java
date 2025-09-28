package Marsrover.command;

import Marsrover.core.Rover;

class MoveCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        return rover.move();
    }
}
