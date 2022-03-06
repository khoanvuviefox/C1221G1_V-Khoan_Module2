package collection_review.data;

import collection_review.function.FresherFunction;
import collection_review.function.Function;
import collection_review.models.Candidate;
import collection_review.models.Fresher;

public class ControllerFresher extends CandidateInfomationCommon {
    private int yearGraduate;
    private String rankOfGraduation;
    private String university;

    static Function fresherService = new FresherFunction();

    static {
        fresherService.add(new Fresher("22", "kk", "hhh", "2002", "Hà Tĩnh", "19001001", "codegym@gmail.com", 1, 2022, "Xuất sắc", "Khoa học Huế"));
    }

    public void addNewFresher() {
        String choice;
        while (true) {
            System.out.println("Add new fresher candidate:");
            super.infomationCandidate();
            System.out.print("Year of graduate: ");
            this.yearGraduate = Integer.parseInt(scanner.nextLine());
            System.out.print("Rank of graduate: ");
            this.rankOfGraduation = scanner.nextLine();
            System.out.print("University: ");
            this.university = scanner.nextLine();
            Fresher fresher = new Fresher(super.candidateId, super.firstName, super.lastName, super.birthday,
                    super.address, super.phone, super.email, Candidate.FRESHER, this.yearGraduate, this.rankOfGraduation, this.university);
            fresherService.add(fresher);
            System.out.println("Cadidate's added.");
            System.out.println("Do you want to continue (Y/N)?");
            choice = scanner.nextLine();

            if ("N".equals(choice)) {
                break;
            }
        }

        System.out.println("Fresher Candidate added:");
        fresherService.display();
    }

    public void searchFresher(String name) {
        boolean isfound = fresherService.searchByName(name);
        if (!isfound) {
            System.out.println("No candidate in list");
        }

    }
}
