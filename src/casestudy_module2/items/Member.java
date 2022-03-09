package casestudy_module2.items;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int member_id;
    private String member_name;
    private String phone_number;
    private String email;
    private String address;
    private String department;

    private List<Member> member = new ArrayList<>();

    public Member() {
    }

    public Member(int member_id, String member_name, String phone_number, String email, String address, String department, List<Member> member) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.department = department;
        this.member = member;
    }

    public Member(String record) {
    }

    public Member(int id, String memberName, String phoneNumber, String email, String address, String department) {
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", member_name='" + member_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", member=" + member +
                '}';
    }
}
