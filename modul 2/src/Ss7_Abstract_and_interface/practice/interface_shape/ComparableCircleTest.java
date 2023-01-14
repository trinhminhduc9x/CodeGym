package Ss7_Abstract_and_interface.practice.interface_shape;

import java.util.Arrays;

class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new  ComparableCircle[5];
        circles [0] = new ComparableCircle(5,"do",true);
        circles [1] = new ComparableCircle(3,"vang",false);
        circles [2] = new ComparableCircle(1,"xanh",false);
        circles [3] = new ComparableCircle(2,"xanh",false);
        circles [4] = new ComparableCircle(6,"xanh",false);
        System.out.println(" Pre-sorted: ");
        for (ComparableCircle circle : circles){
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println(" after -sorted");
        for (ComparableCircle circle : circles){
            System.out.println(circle);
        }
    }
}