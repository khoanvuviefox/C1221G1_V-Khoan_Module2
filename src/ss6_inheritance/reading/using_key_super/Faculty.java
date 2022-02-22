package ss6_inheritance.reading.using_key_super;

public class Faculty {
    public static void main(String[] args) {
        new Faculty();
    }

    public Faculty() {
        System.out.println("Performs Faculty's tasks");
    }
}

class Employee extends Person {
    public Employee () {
        this ("Khoan nè");
        System.out.println("Ok Khoan tiếp nè");
    }

    public Employee (String s) {
        System.out.println(s);
    }
}

class Person {
    public Person () {
        System.out.println("Lại là Khoan đây");
    }
}
