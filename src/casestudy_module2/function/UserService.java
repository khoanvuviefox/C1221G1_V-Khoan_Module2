package casestudy_module2.function;

import casestudy_module2.items.User;
import casestudy_module2.ulits.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    public static String path = "casestudy_module2/data/users.csv";
    List<User> users = new ArrayList<>();

    public UserService() {
        getUsers();
    }

    @Override
    public List<User> getUsers() {
        List<User> newUsers = new ArrayList<>();
        List<String> records = CSVUtils.read(path);
        for (String record : records) {
            newUsers.add(new User(record));
        }
        return users = newUsers;
    }

    @Override
    public User login(String username, String password) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }


    @Override
    public void add(User newUser) {
        users.add(newUser);
        CSVUtils.write(path, users);
    }

    @Override
    public void update() {
        CSVUtils.write(path, users);
    }

    @Override
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getUserById(id) != null;
    }

    @Override
    public boolean checkDuplicateId(double id) {
        for (User user : users) {
            if (user.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateUserName(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicatePhone(String phone) {
        for (User user : users) {
            if (user.getPhone_number().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateEmail(String email) {
//        List<User> users = getUsers();
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateFullName(String fullName) {
        for (User user : users) {
            if (user.getFull_name().equals(fullName))
                return true;
        }
        return false;
    }

    @Override
    public void update(User newUser) {
        for (User user : users) {
            if (user.getId() == newUser.getId()) {
                if (newUser.getFull_name() != null && !newUser.getFull_name().isEmpty())
                    user.setFull_name(newUser.getFull_name());
                if (newUser.getEmail() != null && !newUser.getEmail().isEmpty())
                    user.setEmail(newUser.getEmail());
                if (newUser.getPhone_number() != null && !newUser.getPhone_number().isEmpty())
                    user.setPhone_number(newUser.getPhone_number());
                if (newUser.getAddress() != null && !newUser.getAddress().isEmpty())
                    user.setAddress(newUser.getAddress());
                CSVUtils.write(path, users);
                break;
            }
        }
    }

    @Override
    public void remove(User user) {
        users.remove(user);
        update();
    }
}