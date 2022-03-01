package oop_review.banking_account;

public class TestBanking {
    public static void main(String[] args) {
        ABCBankingAccount Account = new ABCBankingAccount(292002, "Khoan", 292002);
        System.out.println(Account);

        Account.topUp();
        System.out.println(Account);
    }
}
