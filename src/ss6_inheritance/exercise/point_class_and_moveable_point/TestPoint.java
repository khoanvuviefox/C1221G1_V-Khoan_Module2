package ss6_inheritance.exercise.point_class_and_moveable_point;

import java.util.Arrays;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        System.out.println(point);

        MovablePoint moveablePoint = new MovablePoint(2, 2, 2, 3);
        System.out.println(moveablePoint);
        System.out.println("First position of point " + Arrays.toString(moveablePoint.getXY()));
        moveablePoint.move();
        System.out.println("Information of point after one move " + moveablePoint);

    }
}
