package casestudy_module2.function;

import casestudy_module2.items.Member;

import java.util.List;

public interface IMemberService {
    List<Member> getMember();

    void add(Member newMember);


    void update();

    Member getMemberById(int id);

    boolean exist(int id);


    boolean checkDuplicateMemberName(String name);

    boolean checkDuplicateId(double id);

    boolean checkDuplicatePhone(String phone);

    boolean checkDuplicateEmail(String email);

    void update(Member newMember);

    void remove(Member member);
}
