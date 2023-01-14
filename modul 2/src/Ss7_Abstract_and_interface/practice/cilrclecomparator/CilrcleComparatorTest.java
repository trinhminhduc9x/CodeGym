package Ss7_Abstract_and_interface.practice.cilrclecomparator;

import Ss6_Inheritance.practice.systemofgeometric.Circle;

import java.util.Arrays;
import java.util.Comparator;

class CilrcleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle( 12);
        circles[1] = new Circle( 11,"do",true);
        circles[2] = new Circle( 10,"xanh",true);
        System.out.println(" Pre-sorted: ");
        for (Circle circle : circles){
            System.out.println(circle);
        }
        Comparator circleComparator = new CilrcleComparator();
        Arrays.sort(circles,circleComparator);

        System.out.println(" after -sorted");
        for (Circle circle : circles){
            System.out.println(circle);
        }

    }
}