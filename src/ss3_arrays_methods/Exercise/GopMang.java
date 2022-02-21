package ss3_arrays_methods.exercise;

import java.util.Arrays;
public class GopMang {
    public static void main(String[] args)
    {
        int[] array1 = {1,2,3,4,5}; //Mảng khởi tạo 1
        int[] array2 = {6,7,8,9,10}; //Mảng khởi tạo 2
        int length = array1.length + array2.length; //Thêm độ dài của Mảng 1 vào Mảng 2
        int[] array3 = new int[length]; //Mảng kết quả
        int i = 0;
        for (int element : array1) //Sao chép các phần tử của Mảng 2 bằng vòng lặp for-each
        {
            array3[i] = element;
            i++; //Tăng vị trí lên 1
        }
        for (int element : array2) //sao chép các phần tử của Mảng 1 bằng vòng lặp for-each
        {
            array3[i] = element;
            i++;
        }
        System.out.println(Arrays.toString(array3)); //In mảng kết quả
    }
}
