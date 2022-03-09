package casestudy_module2.function;

    import casestudy_module2.items.User;

    import java.util.List;

    public interface IUserService{

        List<User> getUsers();


        User login(String username, String password);

        void add(User newUser);

        User getUserById(int id);

        boolean exist(int id);

        boolean checkDuplicateId(double id);

        boolean checkDuplicateUserName(String userName);

        boolean checkDuplicatePhone(String phone);

        boolean checkDuplicateEmail(String email);

        boolean checkDuplicateFullName(String fullName);

        void update(User user);

        void remove(User user);

        void update();
}
