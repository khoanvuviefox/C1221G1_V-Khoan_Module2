package ss3_arrays_methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static int[] addX(int n, int arr[], int x) {
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public static void main(String[] args) {

        int n = 5;
        int i;
        int arr[] = {10, 4, 6, 7, 8};
        System.out.println("Mảng ban đầu:\n" + Arrays.toString(arr));
        int x = 9;
        arr = addX(n, arr, x);
        System.out.println("\nThêm " + x + " vào mảng:\n" + Arrays.toString(arr));
    }
}