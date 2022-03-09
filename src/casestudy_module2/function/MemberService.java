package casestudy_module2.function;

import casestudy_module2.items.Member;
import casestudy_module2.ulits.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class MemberService implements IMemberService {
    public static String path = "CS2/data/staff.csv";
    List<Member> members = new ArrayList<>();

    public MemberService() {
        getMember();
    }

    public List<Member> getMember() {
        List<Member> newMembers = new ArrayList<>();
        List<String> records = CSVUtils.read(path);
        for (String record : records) {
            newMembers.add(new Member(record));
        }
        return members = newMembers;
    }


    @Override
    public void add(Member newMember) {
        members.add(newMember);
        CSVUtils.write(path, members);
    }

    @Override
    public void update() {
        CSVUtils.write(path, members);
    }

    @Override
    public Member getMemberById(int id) {
        for (Member member : members) {
            if (member.getMember_id() == id)
                return member;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getMemberById(id) != null;
    }

    @Override
    public boolean checkDuplicateMemberName(String memberName) {
        for (Member member : members) {
            if (member.getMember_name().equals(memberName)) ;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateId(double id) {
        for (Member member : members) {
            if (member.getMember_id() == id)
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicatePhone(String phone) {
        for (Member member : members) {
            if (member.getPhone_number().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateEmail(String email) {
        for (Member member : members) {
            if (member.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public void update(Member newMember) {
        for (Member member : members) {
            if (member.getMember_id() == newMember.getMember_id()) {
                if (newMember.getMember_name() != null && !newMember.getMember_name().isEmpty())
                    member.setMember_name(newMember.getMember_name());
                if (newMember.getEmail() != null && !newMember.getEmail().isEmpty())
                    member.setEmail(newMember.getEmail());
                if (newMember.getPhone_number() != null && !newMember.getPhone_number().isEmpty())
                    member.setPhone_number(newMember.getPhone_number());
                if (newMember.getAddress() != null && !newMember.getAddress().isEmpty())
                    member.setAddress(newMember.getAddress());
                if (newMember.getAddress() != null && !newMember.getAddress().isEmpty())
                    member.setAddress(newMember.getAddress());
                CSVUtils.write(path, members);
                break;
            }
        }
    }

    @Override
    public void remove(Member member) {
        members.remove(member);
        update();
    }
}
