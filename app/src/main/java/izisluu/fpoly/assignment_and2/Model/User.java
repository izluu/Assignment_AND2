package izisluu.fpoly.assignment_and2.Model;

public class User {
    private String username, passwword, name;

    public User(String username, String passwword, String name) {
        this.username = username;
        this.passwword = passwword;
        this.name = name;
    }
    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
