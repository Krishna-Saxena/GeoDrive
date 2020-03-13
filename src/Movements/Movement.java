package Movements;

import Flagpoints.Flagpoint;
import Flagpoints.FlagpointAndAction;
import Geometry.Point3D;

import java.util.ArrayList;

public abstract class Movement {
    protected Point3D start;
    protected Point3D end;
    protected ArrayList<FlagpointAndAction> flagpointAndActions;

    protected int nFlagpointsCompleted = 0;

    public Movement(Point3D start, Point3D end, ArrayList<FlagpointAndAction> flagpointAndActions) {
        this.start = start;
        this.end = end;
        this.flagpointAndActions = flagpointAndActions;
    }

    public Movement(Point3D start, Point3D end) {
        this.start = start;
        this.end = end;
    }

    // initial action (set motor power to dt)
    public abstract void start();

    // called every loop
    public void update() {
        if (flagpointAndActions.get(nFlagpointsCompleted).isFlagpointReached())
            flagpointAndActions.get(nFlagpointsCompleted++).act();
        if (isFinished())
            finish();
    }

    //  called every loop
    public boolean isFinished() {
        return (nFlagpointsCompleted == flagpointAndActions.size()) ||
                (flagpointAndActions.get(flagpointAndActions.size()-1).isFlagpointReached());
    }

    // called at end of movement
    public void finish() {
        flagpointAndActions.get(flagpointAndActions.size()-1).act();
    }
}
