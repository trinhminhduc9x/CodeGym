package Ss7_Abstract_and_interface.practice.cilrclecomparator;

import Ss6_Inheritance.practice.systemofgeometric.Circle;

import java.util.Comparator;

public class CilrcleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius()> o2.getRadius())return 1;
        else if (o1.getRadius()<o2.getRadius()) return -1;
        else return 0;
    }
}
