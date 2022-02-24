package ss6_inheritance.exercise.point2d_point3d;

import java.util.Arrays;

public class TestPoint2Dand3D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(10, 15);
        System.out.println(point2D);
        System.out.println("Change to Array " + Arrays.toString(point2D.getXY()));

        Point3D point3D = new Point3D(5, 4, 8);
        System.out.println(point3D);
        System.out.println("Change to Array " + Arrays.toString(point3D.getXY()));

    }
}
