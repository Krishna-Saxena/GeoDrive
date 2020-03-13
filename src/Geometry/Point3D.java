package Geometry;

public class Point3D {
    public Point point;
    public double angle;

    public Point3D(Point point, double angle) {
        this.point = point;
        this.angle = angle;
    }

    public Point3D(double x, double y, double angle) {
        point = new Point(x, y);
        this.angle = angle;
    }
}
