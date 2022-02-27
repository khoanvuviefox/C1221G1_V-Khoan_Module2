package ss7_abstractclass_interface.shape;

public class ShapeTest {

    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            public void resize(double percent) {

            }
        };
        System.out.println(shape);

        shape = new Shape("red", false) {
            @Override
            public void resize(double percent) {

            }
        };
        System.out.println(shape);
    }
}