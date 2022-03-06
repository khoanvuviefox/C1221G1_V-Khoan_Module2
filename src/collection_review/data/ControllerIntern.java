package collection_review.data;

import collection_review.function.Function;
import collection_review.function.InternFunction;
import collection_review.models.Candidate;
import collection_review.models.Intern;

public class ControllerIntern extends CandidateInfomationCommon{
    private String majors;
    private int semester;
    private String university;
    static Function internService = new InternFunction();
    static {
        internService.add(new Intern("99", "aa", "fff", "2002", "Hà Tĩnh", "1111111111", "codegym@gmail.com", 4, "Công nghệ thông tin", 5, "Khoa học Huế"));
    }
    public void addNewIntern() {
        String choice;
        while (true) {
            System.out.println("Add new experience candidate:");
            super.infomationCandidate();
            System.out.print("Major: ");
            this.majors = scanner.nextLine();
            System.out.print("Semester: ");
            this.semester = Integer.parseInt(scanner.nextLine());
            System.out.print("University: ");
            this.university = scanner.nextLine();

            Intern intern = new Intern(super.candidateId, super.firstName, super.lastName, super.birthday,
                    super.address, super.phone, super.email, Candidate.INTERN, this.majors,this.semester,this.university);
            internService.add(intern);

            System.out.println("Cadidate's added.");
            System.out.println("Do you want to continue (Yes/No)?");
            choice = scanner.nextLine();

            if ("No".equals(choice)) {
                break;
            }
        }
        System.out.println("Internship Candidate added:");
        internService.display();
    }
    public void searchIntern(String name){
        boolean isfound = internService.searchByName(name);
        if (!isfound){
            System.out.println("No candidate in list");
        }

    }
}
