package ss5_accessmodifier_staticmethod_staticproperty.practice;

public class Car {
    private String name;
    private String engie;

    public static int numberOfCar;

    public Car (String name, String engine) {
        this.name = name;
        this.engie = engine;
        numberOfCar++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngie() {
        return engie;
    }

    public void setEngie(String engie) {
        this.engie = engie;
    }

    public static int getNumberOfCar() {
        return numberOfCar;
    }

    public static void setNumberOfCar(int numberOfCar) {
        Car.numberOfCar = numberOfCar;
    }
}
