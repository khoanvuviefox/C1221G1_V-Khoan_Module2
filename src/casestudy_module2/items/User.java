package casestudy_module2.items;

public class User {
    private int id;
    private String full_name;
    private String phone_number;
    private String email;
    private String address;
    private String username;
    private String password;
    private UserType userType;
    private UserStatus userStatus;

    public User(int id, String full_name, String phone_number, String email, String address, String username, String password, UserType userType, UserStatus userStatus) {
        this.id = id;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userStatus = userStatus;
    }

    public User(String draw) {
        String[] strings = draw.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.full_name = strings[1];
        this.phone_number = strings[2];
        this.email = strings[3];
        this.address = strings[4];
        this.username = strings[5];
        this.password = strings[6];
        this.userType = UserType.parseUserType(strings[7]);
        this.userStatus= UserStatus.parseUserStatus(strings[8]);
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", userStatus=" + userStatus +
                '}';
    }
}
