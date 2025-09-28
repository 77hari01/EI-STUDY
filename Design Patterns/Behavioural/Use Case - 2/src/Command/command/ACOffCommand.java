package Command.command;

public class ACOffCommand implements Command {
    private AirConditioner ac;

    public ACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.off();
    }

    @Override
    public void undo() {
        ac.on();
    }
}
