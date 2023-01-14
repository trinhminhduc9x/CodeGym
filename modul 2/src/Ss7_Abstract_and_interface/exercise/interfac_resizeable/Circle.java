package Ss7_Abstract_and_interface.exercise.interfac_resizeable;


import java.util.Comparator;

public class Circle extends Shape implements Comparator<Circle> {
    private double radius = 1.0;
    public Circle(){
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled ) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    public  double getPerimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                +"A Circle with area="
                + getArea()
                + " , which is a subclass of "
                + super.toString();
    }

    @Override
    public void resizeable(double percent) {
       setRadius(getRadius()*percent/100);
    }

    @Override
    public int compare(Circle o1, Circle o2) {
        return 0;
    }
}
