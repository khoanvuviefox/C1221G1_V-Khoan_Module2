package ss5_accessmodifier_staticmethod_staticproperty.exercise.xaydung_lopchighi;

public class Student {
    private String name = "Joh";
    private  String classes = "C02";

    public Student() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    void students() {
        System.out.println(name + " " + classes);
    }
}
