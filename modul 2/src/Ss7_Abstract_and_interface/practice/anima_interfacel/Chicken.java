package Ss7_Abstract_and_interface.practice.anima_interfacel;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return " Chicken: cluck- cluck ! ";
    }

    @Override
    public String howToEat() {
        return "could be fried ";
    }
}
