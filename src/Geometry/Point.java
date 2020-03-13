package Geometry;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distTo(Point p2) {
        return Math.hypot(x-p2.x, y-p2.y);
    }

    public double angleTo(Point p2) {
        return Math.atan2(p2.y-y, p2.x-x);
    }
}
