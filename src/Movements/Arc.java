package Movements;

import Constants.RobotConstants;
import Flagpoints.Flagpoint;
import Flagpoints.FlagpointAndAction;
import Geometry.CircleGenerator;
import Geometry.Circle;
import Geometry.Point3D;

import java.util.ArrayList;

public class Arc extends Movement{
    private final double leadingPower;
    private final boolean isCCW;
    private final Circle arcCircle;
    private final double radius;
    private final double tw;

    public Arc (Point3D start, Point3D end, double leadingPower, boolean isCCW, FlagpointAndAction endCond) {
        super(start, end, new ArrayList<FlagpointAndAction>());
        super.flagpointAndActions.add(endCond);
        this.leadingPower = leadingPower;
        this.isCCW = isCCW;
        arcCircle = CircleGenerator.generateCircle(start, end);

        radius = arcCircle.radius;
        tw = RobotConstants.TRACKWIDTH;
    }

    public Arc (Point3D start, Point3D end, double leadingPower, boolean isCCW, FlagpointAndAction endCond,
                ArrayList<FlagpointAndAction> midMovementFlagpoints) {
        super(start, end, midMovementFlagpoints);
        super.flagpointAndActions.add(endCond);
        this.leadingPower = leadingPower;
        this.isCCW = isCCW;
        arcCircle = CircleGenerator.generateCircle(start, end);

        radius = arcCircle.radius;
        tw = RobotConstants.TRACKWIDTH;
    }


    @Override
    public void start() {
        if (isCCW)
            RobotMotionFunctions.setPower(leadingPower*(radius - 0.5*tw)/(radius+0.5*tw), leadingPower);
        else
            RobotMotionFunctions.setPower(leadingPower, leadingPower*(radius - 0.5*tw)/(radius+0.5*tw));
    }

    @Override
    public void update() {
        if (flagpointAndActions.get(nFlagpointsCompleted).isFlagpointReached())
            flagpointAndActions.get(nFlagpointsCompleted++).act();
        if (isFinished())
            finish();
    }

    @Override
    public void finish() {
        flagpointAndActions.get(flagpointAndActions.size()-1).act();
    }
}
