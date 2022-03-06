package collection_review.data;

import collection_review.function.ExperienceFunction;
import collection_review.function.Function;
import collection_review.models.Candidate;
import collection_review.models.Experience;

public class ControllerExperience extends CandidateInfomationCommon {
    private double expInYear;
    private String proSkill;
    static Function experienceService = new ExperienceFunction();

    static {
        experienceService.add(new Experience("1","Khoan","Vũ","2002","Hà Tĩnh","0973882821","codegym@gmail.com",1,2,"Koltin"));
    }
    public void addNewExperience() {
        String choice;
        while (true) {
            System.out.println("Add new experience candidate:");
            super.infomationCandidate();
            System.out.print("Year of experience: ");
            this.expInYear = Double.parseDouble(scanner.nextLine());
            System.out.print("Professional Skill: ");
            this.proSkill = scanner.nextLine();

            Experience experience = new Experience(super.candidateId, super.firstName, super.lastName, super.birthday,
                    super.address, super.phone, super.email, Candidate.EXPERIENCE, this.expInYear, this.proSkill);
            experienceService.add(experience);
            System.out.println("Cadidate's added.");
            System.out.println("Do you want to continue (Y/N)?");
            choice = scanner.nextLine();

            if ("N".equals(choice)) {
                break;
            }
        }
        System.out.println("Experience Candidate added:");
        experienceService.display();
    }
    public void searchExperience(String name){
        boolean isfound = experienceService.searchByName(name);
        if (!isfound){
            System.out.println("No candidate in list");
        }

    }
}
