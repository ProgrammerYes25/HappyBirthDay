package no2114_2127.project.myapplication;

public class MemberClass {
    private String name;
    private String email;
    private String password;
    private String birthDay;

    public MemberClass(String name, String email, String password, String birthDay){
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDay = birthDay;
    }
    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter methods for passwordCheck
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String passwordCheck) {
        this.birthDay = passwordCheck;
    }
}
