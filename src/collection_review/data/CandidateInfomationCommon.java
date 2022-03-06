package collection_review.data;

import java.util.Scanner;

public class CandidateInfomationCommon {
    protected String candidateId;
    protected String firstName;
    protected String lastName;
    protected String birthday;
    protected String address;
    protected String phone;
    protected String email;

    Scanner scanner = new Scanner(System.in);

    public void infomationCandidate() {
        System.out.print("Id: ");
        this.candidateId = scanner.nextLine();
        System.out.print("First name: ");
        this.firstName = scanner.nextLine();
        System.out.print("Last name: ");
        this.lastName = scanner.nextLine();
        System.out.print("Year of birth: ");
        this.birthday = scanner.nextLine();
        System.out.print("Address: ");
        this.address = scanner.nextLine();
        System.out.print("Phone: ");
        this.phone = scanner.nextLine();
        System.out.print("Email: ");
        this.email = scanner.nextLine();
    }
}
