package Ss7_Abstract_and_interface.exercise.interfac_resizeable;



public class Rectangle extends Shape {
    public double width = 1.0;
    public double length =1.0;
    public Rectangle(){

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getAre(){
        return width * this.length;
    }
    public  double getPerimeter(){
        return  2*(width+this.length);
    }

    @Override
    public void resizeable(double percent) {
        setLength(getLength()*percent/100);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                +"A Circle with area="
                + getAre()
                + ", which is a subclass of "
                + super.toString();
    }
}
