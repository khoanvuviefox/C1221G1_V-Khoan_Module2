package collection_review.models;

public class Fresher extends Candidate {
    private int yearGraduate;
    private String rankOfGraduation;
    private String university;

    public Fresher(String id, String firstName, String lastName, String birthday, String address, String  phone, String email, int candidateType, int yearGraduate, String rankOfGraduation, String university) {
        super(id, firstName, lastName, birthday, address, phone, email, candidateType);
        this.yearGraduate = yearGraduate;
        this.rankOfGraduation = rankOfGraduation;
        this.university = university;
    }

    public Fresher() {

    }

    public int getYearGraduate() {
        return yearGraduate;
    }

    public void setYearGraduate(int yearGraduate) {
        this.yearGraduate = yearGraduate;
    }

    public String getRankOfGraduation() {
        return rankOfGraduation;
    }

    public void setRankOfGraduation(String rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fresher that = (Fresher) o;
        return super.getId() == that.getId();
    }
}
