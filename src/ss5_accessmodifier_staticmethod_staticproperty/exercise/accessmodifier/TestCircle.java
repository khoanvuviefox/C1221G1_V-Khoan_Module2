package ss5_accessmodifier_staticmethod_staticproperty.exercise.accessmodifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        System.out.println("This radius is: " + circle1.getRadius());
        System.out.println("This area is: " + circle1.getArea());
    }
}
