package collection_review.function;

import collection_review.models.Candidate;
import collection_review.models.Intern;

import java.util.ArrayList;
import java.util.List;

public class InternFunction implements Function<Intern> {
    private List<Candidate> internList = new ArrayList<>();

    public InternFunction(List<Candidate> internList) {
        this.internList = internList;
    }

    public InternFunction() {

    }

    public List<Candidate> getInternList() {
        return internList;
    }

    public void setInternList(List<Candidate> internList) {
        this.internList = internList;
    }

    @Override
    public void add(Intern object) {
        this.internList.add(object);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {
        for (Candidate intern : internList) {
            System.out.println(intern);
        }
    }

    @Override
    public boolean searchByName(String name) {
        boolean result = false;
        name = name.toLowerCase();
        for (Candidate intern : internList) {
            boolean isContainFirstName = intern.getFirstName().toLowerCase().contains(name);
            boolean isContainLastName = intern.getLastName().toLowerCase().contains(name);
            if (isContainFirstName || isContainLastName) {
                System.out.println(intern);
                result = true;
            }
        }
        return result;
    }
}
