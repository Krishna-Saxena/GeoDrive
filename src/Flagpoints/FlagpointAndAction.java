package Flagpoints;

public class FlagpointAndAction {
    private Flagpoint flagpoint;
    private Action action;

    public FlagpointAndAction(Flagpoint flagpoint, Action action) {
        this.flagpoint = flagpoint;
        this.action = action;
    }

    public boolean isFlagpointReached() {
        return flagpoint.isFlagpointCrossed();
    }

    public void act() {
        action.act();
    }
}
