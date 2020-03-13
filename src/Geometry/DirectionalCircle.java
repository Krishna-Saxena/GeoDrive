package Geometry;

public class DirectionalCircle {
    public final boolean isCCW;
    public final Circle circle;

    public DirectionalCircle(Point3D posI, Point3D posF, boolean isCCW) {
        circle = CircleGenerator.generateCircle(posI, posF);
        this.isCCW = isCCW;
    }
}
