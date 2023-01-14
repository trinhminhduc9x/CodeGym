package Ss6_Inheritance.exercise.point_and_moveablepoint;

class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);
        movablePoint.move();
        movablePoint.setSpeed(1,1);
        System.out.println(movablePoint.move());
        movablePoint.setSpeed(2,2);
        System.out.println(movablePoint.move());


    }

}