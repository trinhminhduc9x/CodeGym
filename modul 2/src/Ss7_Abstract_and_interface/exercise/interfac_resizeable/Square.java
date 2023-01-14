package Ss7_Abstract_and_interface.exercise.interfac_resizeable;

public class Square extends Shape {
    public double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return side *side;
    }

    @Override
    public void resizeable(double percent) {
       setSide(getSide()*percent/100);
    }

    @Override
    public String toString() {
        return "A Rectangle with side="
                + getSide()
                +"A Circle with area="
                + getArea()
                + " , which is a subclass of "
                + super.toString();
    }
}
