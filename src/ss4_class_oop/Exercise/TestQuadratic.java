package SS4_ClassOOPS.Exercise;

import java.util.Scanner;

public class TestQuadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ClassOOPS.Exercise.QuadraticEquation.explain());
        System.out.println("nhập a: ");
        double a = sc.nextDouble();
        while (a == 0) {
            System.out.println("a phải lớn hơn 0, nhập a: ");
            a = sc.nextDouble();
        }
        System.out.println("nhập b: ");
        double b = sc.nextDouble();
        System.out.println("nhập c: ");
        double c = sc.nextDouble();
        System.out.println("nhập d: ");
        double d = sc.nextDouble();

        ClassOOPS.Exercise.QuadraticEquation _2= new ClassOOPS.Exercise.QuadraticEquation(a,b,c,d);
        if (_2.getDiscriminant()>0){
            System.out.println("nghiệm 1: "+_2.getRoot1());
            System.out.println("nghiệm 2: "+_2.getRoot2());
        }else if (_2.getDiscriminant()==0){
            System.out.println("nghiệm kép : "+_2.getRoot1());
        }else {
            System.out.println("vô nghiệm`");
        }
    }
}