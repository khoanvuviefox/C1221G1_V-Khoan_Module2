package collection_review.function;

import collection_review.models.Candidate;
import collection_review.models.Fresher;

import java.util.ArrayList;
import java.util.List;

public class FresherFunction implements Function<Fresher> {
    private List<Candidate> fresherList = new ArrayList<>();

    public FresherFunction (List<Candidate> fresherList) {
        this.fresherList = fresherList;
    }

    public FresherFunction() {

    }

    public List<Candidate> getFresherList() {
        return fresherList;
    }

    public void setFresherList(List<Candidate> fresherList) {
        this.fresherList = fresherList;
    }

    @Override
    public void add(Fresher object) {
        this.fresherList.add(object);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {
        for (Candidate fresher : fresherList) {
            System.out.println(fresher);
        }
    }

    @Override
    public boolean searchByName(String name) {
        boolean result = false;
        name = name.toLowerCase();
        for (Candidate fresher : fresherList) {
            boolean isContainFirstName = fresher.getFirstName().toLowerCase().contains(name);
            boolean isContainLastName = fresher.getLastName().toLowerCase().contains(name);
            if (isContainFirstName || isContainLastName) {
                System.out.println(fresher);
                result = true;
            }
        }
        return result;
    }
}
