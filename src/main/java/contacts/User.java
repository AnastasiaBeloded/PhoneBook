package contacts;

public class User {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String description;


    public String getName() {
        return name;
    }
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }
    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }
    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public User setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "User{"+ "name='" + name + ", lastName='" + lastName + ", phone='" + phone + ", email='" + email +
                ", address='" + address + ", description='" + description + '}';
    }
}
