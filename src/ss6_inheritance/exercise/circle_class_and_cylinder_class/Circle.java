package ss6_inheritance.exercise.circle_class_and_cylinder_class;

public class Circle {
    private String color = "black";
    private String fillColor = "white";
    private double radius = 0;

    public Circle(String color, String fillColor, double radius) {
        this.color = color;
        this.fillColor = fillColor;
        this.radius = radius;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public double getCircus() {
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return  "+ bán kính: " + this.getRadius() + "\n" +
                "+ màu: " + this.getColor() + "\n" +
                "+ màu bên trong: " + this.getFillColor() + "\n";
    }
}
