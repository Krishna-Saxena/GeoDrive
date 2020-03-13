package Geometry;

/**
 * The center of a circle lies on the intercept of two points' secant lines
 * The slope of a secant point is the tangent of (PI/2rad + the angle of the tangent at that point)
 */
public class CircleGenerator {
    private static final Point origin = new Point(0.0,0.0);

    public static Circle generateCircle(double thetaI, Point pF, double thetaF) {
        Line l1 = new Line(Math.tan(thetaI+Math.PI/2), origin);
        Line l2 = new Line(Math.tan(thetaF+Math.PI/2), pF);
        Point intercept = l1.intercept(l2);
        return new Circle(intercept.distTo(origin), intercept);
    }
    public static Circle generateCircle(Point pI, double thetaI, Point pF, double thetaF) {
        return generateCircle(thetaI, new Point(pF.x-pI.x, pF.y-pI.y), thetaF);
    }
    public static Circle generateCircle(Point3D posI, Point3D posF) {
        return generateCircle(posI.point, posI.angle, posF.point, posF.angle);
    }
}
