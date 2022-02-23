package giaithuat;

import java.util.Scanner;

public class CodeGym {
    public static void main(String args[]) {
        int i, j;
        Scanner scanner = new Scanner(System.in);
        int rows = 6;
        System.out.println("Ký tự in: ");
        char z = (char) scanner.nextInt();

        for (i = 1; i <= rows; i++) {
            for (j = rows; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print(z);
            for (j = 1; j < (i - 1) * 2; j++) {
                System.out.print(" ");
            }
            if (i == 1) {
                System.out.print("\n");
            } else {
                System.out.print(z + "\n");
            }
        }

        for (i = rows - 1; i >= 1; i--) {
            for (j = rows; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print(z);
            for (j = 1; j < (i - 1) * 2; j++) {
                System.out.print(" ");
            }
            if (i == 1) {
                System.out.print("\n");
            } else {
                System.out.print(z + "\n");
            }
        }
    }
}