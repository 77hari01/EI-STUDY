package Marsrover.command;

import Marsrover.core.Rover;

public interface Command {
    boolean execute(Rover rover);
}
