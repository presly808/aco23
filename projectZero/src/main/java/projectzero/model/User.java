package projectzero.model;

public class User {

    private final int email;
    private String logg;
    private String pass;

    public User(int email, String logg, String pass) {
        this.email = email;
        this.logg = logg;
        this.pass = pass;
    }

    public User(int email) {
        this.email = email;
    }


    public int getEmail() {
        return email;
    }

    public String getLogg() {
        return logg;
    }

    public void setLogg(String logg) {
        this.logg = logg;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "email=" + email +
                ", logg='" + logg + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
