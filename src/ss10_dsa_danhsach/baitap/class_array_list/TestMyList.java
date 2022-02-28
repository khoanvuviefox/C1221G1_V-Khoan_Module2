package ss10_dsa_danhsach.baitap.class_array_list;

public class TestMyList {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        print(list.getData());
        System.out.println(list.indexOf("e"));
        System.out.println(list.indexOf("a"));
        list.remove(1);
        list.add("g",1);
        print(list.getData());
        MyList<String> clone = list.clone();
        System.out.println(clone.contains("b"));
        System.out.println(clone.contains("d"));
        System.out.println(clone.get(3));
        System.out.println(clone.size());
        clone.clear();
        System.out.println(clone.size());
        print(clone.getData());

    }

    static void print(Object[] list) {
        for (Object x : list) {
            if (!(x == null)) {
                System.out.println((String) x);
            }
        }
        System.out.println("\n");
    }
}
