package collection_review.models;

public class Candidate {
    private String id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String address;
    private String phone;
    private String email;
    private int candidateType = FRESHER;

    public static int EXPERIENCE = 0;
    public static int FRESHER = 1;
    public static int INTERN = 2;

    public Candidate(String id, String firstName, String lastName, String birthday, String address, String phone, String email, int candidateType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public Candidate() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return
                firstName + ' ' +
                        lastName + " | " +
                        birthday + " | " +
                        address + " | " +
                        phone + " | " +
                        email + " | " +
                        candidateType;
    }
}
