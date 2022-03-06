package collection_review.models;

public class Experience extends Candidate {
    private double expInYear;
    private String proSkill;

    public Experience(String id, String firstName, String lastName, String birthday, String address, String phone, String email, int candidateType, double expInYear, String proSkill) {
        super(id, firstName, lastName, birthday, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience() {

    }

    public double getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(double expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return super.getId() == that.getId();
    }
}
