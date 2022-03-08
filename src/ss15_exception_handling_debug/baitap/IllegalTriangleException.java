package ss15_exception_handling_debug.baitap;

public class IllegalTriangleException {
    private double side1;
    private double side2;
    private double side3;

    public IllegalTriangleException() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }

    public double getArea() {
        return (side1 + side2 + side3) / 2;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    public void setSide1() {
        this.side1 = side1;
    }
    public void setSide2() {
        this.side2 = side2;
    }
    public void setSide3() {
        this.side3 = side3;
    }
    public String toString() {
        return "Triangle: Side 1 = " + side1 + " Side 2 = " + side2 + " Side 3 = " + side3;
    }
}
