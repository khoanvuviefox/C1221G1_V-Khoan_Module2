package collection_review.view;

import collection_review.manage_candidates_of_company.ControllerCandidate;

public class View {
    public static void main(String[] args) {
        ControllerCandidate candidateController = new ControllerCandidate();
        candidateController.mainMenu();
    }
}
