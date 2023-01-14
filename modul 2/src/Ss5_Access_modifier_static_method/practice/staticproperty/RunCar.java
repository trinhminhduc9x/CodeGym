package Ss5_Access_modifier_static_method.practice.staticproperty;

public class RunCar {
    public static void main(String[] args) {
        Car car = new Car("min duc", "duc");
        car.display();
        System.out.println(Car.getNumberOFCars());
        Car car1 = new Car("minh dc", "duc");
        car1.display();
        System.out.println(Car.getNumberOFCars());
        Car car2 = new Car("mih dc", "duc");
        car2.display();
        System.out.println(Car.getNumberOFCars());
    }
}
