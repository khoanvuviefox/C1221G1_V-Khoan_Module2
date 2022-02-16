package Introduction;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        double vnd = 22940;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to exchange (USD): ");
        usd = scanner.nextDouble();
        double exchange = usd * 22940;
        System.out.print("Enter amount exchanged: (VNĐ): " + exchange);
    }
}
