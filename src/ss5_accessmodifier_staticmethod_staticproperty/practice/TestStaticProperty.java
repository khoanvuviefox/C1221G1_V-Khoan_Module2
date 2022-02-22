package ss5_accessmodifier_staticmethod_staticproperty.practice;

public class TestStaticProperty {

    public static void main(String[] args) {
        Car car1 = new Car("Vinfast","Honda");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Mazda","Kia");
        System.out.println(Car.numberOfCar);
    }
}
