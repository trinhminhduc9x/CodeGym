package Ss6_Inheritance.exercise.point_and_moveablepoint;

import java.util.Arrays;

class PointTest {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point);
        point.setXY(3, 4);
        System.out.println(" arr : " + Arrays.toString(point.getXY()));
        System.out.println(" arr : " + Arrays.toString(point.getXY()));
    }

}