public class User {
    public String username;
    public String password;

    public User(String username){
        setUsername(username);
        password = "123";
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
