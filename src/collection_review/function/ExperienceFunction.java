package collection_review.function;

import collection_review.models.Candidate;
import collection_review.models.Experience;

import java.util.ArrayList;
import java.util.List;

public class ExperienceFunction implements Function <Experience>{
    private List<Candidate> experienceList = new ArrayList<>();

    public ExperienceFunction() {
    }

    public ExperienceFunction(List<Candidate> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Candidate> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Candidate> experienceList) {
        this.experienceList = experienceList;
    }

    @Override
    public void add(Experience experience) {
        this.experienceList.add(experience);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {
        for (Candidate experience : experienceList) {
            System.out.println(experience);
        }
    }

    @Override
    public boolean searchByName(String name) {
        boolean result = false;
        name = name.toLowerCase();
        for (Candidate experience : experienceList) {
            boolean isContainFirstName = experience.getFirstName().toLowerCase().contains(name);
            boolean isContainLastName = experience.getLastName().toLowerCase().contains(name);
            if (isContainFirstName || isContainLastName) {
                System.out.println(experience);
                result = true;
            }
        }
        return result;
    }
}
