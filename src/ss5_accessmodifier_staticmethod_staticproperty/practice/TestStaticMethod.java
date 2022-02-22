package ss5_accessmodifier_staticmethod_staticproperty.practice;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(209, "Khoan");
        Student s2 = new Student(222, "Ha");
        Student s3 = new Student(111, "Tinh");

        s1.display();
        s2.display();
        s3.display();
    }
}
