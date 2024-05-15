package elements;

public class User {
    private String creds;
    private String login;
    private String password;
    private String id;

    public User(String creds, String login, String password, String id){
        this.creds = creds;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }

    public String getCreds(){
        return creds;
    }
    public String getId(){
        return id;
    }
}
