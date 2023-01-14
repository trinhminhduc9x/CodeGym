package Ss6_Inheritance.exercise.point2d;

import java.util.Arrays;

class Point3dTest {
    public static void main(String[] args) {
        Point3d point3d = new Point3d(10,12,13);
        System.out.println(point3d);
        System.out.println(Arrays.toString(point3d.getXy()));
        System.out.println(Arrays.toString(point3d.getXyz()));
        point3d.setX(5);
        point3d.setZ(6);
        point3d.setY(7);
        System.out.println(Arrays.toString(point3d.getXyz()));
        point3d.setXy(1,3);
        System.out.println(Arrays.toString(point3d.getXyz()));
        point3d.setXyz(1,2,3);
        System.out.println(Arrays.toString(point3d.getXyz()));

    }

}