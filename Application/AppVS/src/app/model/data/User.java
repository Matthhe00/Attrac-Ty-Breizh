package app.model.data;

public class User {
    private String login;
    private String pwd;
    private String role;

    public User(){
        this.login = "";
        this.pwd = "";
        this.role = "";
    }

    public User(String login , String pwd) {
        this.login = login;
        this.pwd = pwd;
        this.role = "user";
    }

    public User(String login , String pwd, String role) {
        this.login = login;
        this.pwd = pwd;
        this.role = role;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setMdp(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public User getUser() {
        return this;
    }

    public String toString() {
        return "User [login=" + login + ", pwd=" + pwd + ", role=" + role + "]";
    } 
}
