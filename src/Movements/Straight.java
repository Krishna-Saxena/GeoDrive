package Movements;

import Flagpoints.FlagpointAndAction;
import Geometry.Point3D;

import java.util.ArrayList;

public class Straight extends Movement {
    private final double dist;
    private final double power;

    public Straight (Point3D start, Point3D end, double power, boolean isFwd, FlagpointAndAction endCond) {
        super(start, end, new ArrayList<FlagpointAndAction>());
        super.flagpointAndActions.add(endCond);

        dist = start.point.distTo(end.point);
    }

    @Override
    public void start() {

    }
}
