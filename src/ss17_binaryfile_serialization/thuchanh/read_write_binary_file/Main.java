package ss17_binaryfile_serialization.thuchanh.read_write_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Khoan", "Hà Tĩnh"));
        students.add(new Student(2, "Võ Thị Thanh Ngân", "Hà Tĩnh"));
        writeToFile("D:\\C1221G1_V-Khoan_Module2\\src\\ss17_binaryfile_serialization\\thuchanh\\read_write_binary_file\\student.txt", students);

    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();;
    }
}
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
