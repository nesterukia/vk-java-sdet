package elements;

public class User {
    private String creds;
    private String login;
    private String password;

    public User(String creds, String login, String password){
        this.creds = creds;
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    public String getCreds(){
        return this.creds;
    }
}
