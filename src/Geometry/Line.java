package Geometry;

/**
 * Line represented by slope m and y intercept b
 * If the line is vertical, the slope is Double.POSITIVE_INFINITY and the intercept is the x intercept
 */
public class Line {
    double m;
    double b;

    public Line(double slope, Point p) {
        if (slope == Double.POSITIVE_INFINITY || slope == Double.POSITIVE_INFINITY) {
            m = Double.POSITIVE_INFINITY;
            b = p.x;
        }
        else {
            m = slope;
            b = p.y - m*p.x;
        }
    }

    public Line(Point p1, Point p2) {
        this(((p2.y-p1.y)/(p2.x-p1.x)), p1);
    }

    public Point intercept(Line l2) {
        // slopes are the same, no intercept or infinite intercepts
        if (Math.abs(m-l2.m) < 1e-3) {
            return null;
        }
        // one of the lines is vertical
        if (m == Double.POSITIVE_INFINITY) {
            return new Point(b,l2.m*b + l2.b);
        }
        if (l2.m == Double.POSITIVE_INFINITY) {
            return new Point(l2.b, m*l2.b + b);
        }
        // two non vertical lines with different slopes
        double x = (l2.b-b)/(m-l2.m);
        return new Point(x, m*x+b);
    }
}
