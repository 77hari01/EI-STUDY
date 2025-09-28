package Command;

import Command.command.Light;
import Command.RemoteControl;
import Command.command.*;

import java.util.*;

public class CommandPatternDemo {
    public static void main(String[] args) {

        Light light = new Light();
        AirConditioner ac = new AirConditioner();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command acOn = new ACOnCommand(ac);
        Command acOff = new ACOffCommand(ac);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();

        remote.setCommand(acOn);
        remote.pressButton();

        remote.setCommand(acOff);
        remote.pressButton();
    }
}