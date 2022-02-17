package ArraysMethods.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int x = scanner.nextInt();
        int arr[] = {3, 5, 1, 4, 6, 7, 8 ,9};
        System.out.println(Arrays.toString(arr));
        boolean found = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                arr[i] = arr[i + 1];
                found = true;
                count++;
                System.out.printf("Vi tri cua %d la: %d \n", x, i + 1);

            }
            if (found && i < arr.length - 1)
                arr[i] = arr[i + 1];
        }
        System.out.print("[");
        for (int i = 0; i < arr.length - count; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
    }
}