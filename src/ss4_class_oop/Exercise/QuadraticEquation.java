package SS4_ClassOOPS.Exercise;

public class QuadraticEquation {
    private Object seft = this;
    private double a;
    private double b;
    private double c;
    private double d;

    public Object getSeft() {
        return seft;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public static String explain() {
        return "QuadraticEquation: ax^2+bx+c=d";
    }

    public QuadraticEquation(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.c = this.c - this.d;

    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        double root1 = 0;
        if (this.getDiscriminant() >= 0) {
            root1 = (-this.b - Math.sqrt(this.getDiscriminant())) / (2 * this.a);
        }
        return root1;
    }

    public double getRoot2() {
        double root2 = 0;
        if (this.getDiscriminant() >= 0) {
            root2 = (-this.b + Math.sqrt(this.getDiscriminant())) / (2 * this.a);
        }
        return root2;
    }
}
