package ss7_abstractclass_interface.baitap.resizeable;


import ss7_abstractclass_interface.shape.Circle;
import ss7_abstractclass_interface.shape.Rectangle;
import ss7_abstractclass_interface.shape.Shape;
import ss7_abstractclass_interface.shape.Square;

public class TestResizeable {
    public static void main(String[] args) {
        int x = (int) Math.floor(Math.random() * 10);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(x, "yellow", false);
        shapes[1] = new Rectangle(x, x, "infinity", true);
        shapes[2] = new Square(x, "melinda", true);
        for (Shape a : shapes){
            System.out.println(a);
        }

        for (Shape a : shapes) {
            a.resize(Math.random() * 1000);
        }
        System.out.println("\n");
        Shape.printShape(shapes);
    }
}
