package Ss6_Inheritance.exercise.circlea_and_cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder() {
    }
    public Cylinder( double height) {
        this.height = height;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea() * getHeight();
    }


    @Override
    public String toString() {
        return "Cylinder{" +
               super.toString() +
                "height=" + height +
                ", Area=" + getArea() + '\'' +
                '}';
    }
}
