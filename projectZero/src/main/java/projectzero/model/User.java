package projectzero.model;

public class User {

    private final int email;
    private String login;
    private String pass;

    public User(int email, String login, String pass) {
        this.email = email;
        this.login = login;
        this.pass = pass;
    }

    public User(int email) {
        this.email = email;
    }


    public int getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String logg) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "email=" + email +
                ", logg='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
