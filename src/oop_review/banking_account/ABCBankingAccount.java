package oop_review.banking_account;

import java.text.DecimalFormat;
import java.util.Scanner;


   public class ABCBankingAccount {
        private long accountNumber;
        private String accountName;
        private double accountBalance = 50;
        public static final double INTERESTRATE = 0.035;

        public ABCBankingAccount(long accountNumber, String accountName, double accountBalance) {
            this.accountNumber = accountNumber;
            this.accountName = accountName;
            this.accountBalance = accountBalance;
        }

        public ABCBankingAccount(long accountNumber, String accountName) {
            this.accountNumber = accountNumber;
            this.accountName = accountName;
        }

        public ABCBankingAccount() {

        }

        public long getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public double getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(double accountBalance) {
            this.accountBalance = accountBalance;
        }

        public void topUp() {
            Scanner scanner = new Scanner(System.in);
            double amount = 0;
            do {
                System.out.print("Enter top-up amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Invalid amount");
                }
            } while (amount <= 0);
            this.accountBalance += amount;
        }

        public double withdraw() {
            Scanner scanner = new Scanner(System.in);
            double amount = 0;
            do {
                System.out.print("Enter withdraw amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Invalid amount");
                }
            } while (amount > getAccountBalance());

            this.accountBalance -= amount;
            return amount;
        }

        public double transferMoney() {
            Scanner scanner = new Scanner(System.in);
            double amount = 0;
            do {
                System.out.print("Enter transfer amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Invalid amount");
                }
            } while (amount > getAccountBalance());

            this.accountBalance -= amount;
            return amount;
        }

        public void maturity() {
            this.accountBalance = this.accountBalance * (1 + INTERESTRATE);
        }

        @Override
        public String toString() {
            DecimalFormat formatter = new DecimalFormat("###,###,###.00");
            String accountBalanceCurrencyFormat = formatter.format(accountBalance) + " VNĐ";

            return "accountNumber: " + accountNumber +
                    ", accountName: '" + accountName + '\'' +
                    ", accountBalance: " + accountBalanceCurrencyFormat;
        }
    }
