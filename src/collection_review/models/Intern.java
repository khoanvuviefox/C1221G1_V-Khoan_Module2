package collection_review.models;

public class Intern extends Candidate {
    private String majors;
    private int semester;
    private String university;

    public Intern(String id, String firstName, String lastName, String birthday, String address, String phone, String email, int candidateType, String majors, int semester, String university) {
        super(id, firstName, lastName, birthday, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }

    public Intern() {

    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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
        Intern that = (Intern) o;
        return super.getId() == that.getId();
    }
}
