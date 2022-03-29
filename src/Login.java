import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private String userName,password;
    public String path;
    public String absolutePath;
    private Connect databaseConnection;

    public Login(String userName,String password)
    {
        this.userName = userName;
        this.password = password;
        setPath();
        getParentPath();
        databaseConnection = new Connect(absolutePath, absolutePath);
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPath() {
        path = "database/userDB.db";
    }

    public void getParentPath(){
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            setAbsolutePath(f.getAbsolutePath());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String getPath() {
        return path;
    }

    public ResultSet getUserDB(){
        ResultSet result = databaseConnection.loadUser();
        return result;
    }

    public boolean validate(String usernameUser, String passwordUser) {
        ResultSet result = getUserDB();
        try{
            while (result.next()){
                String username = result.getString("Username");
                String password = result.getString("Password");
                //System.out.println("Username:" + username + "   " + password);
                if(usernameUser.equals(username) && passwordUser.equals(password))
                {
                    System.out.println("Successfully logged in");
                    return true;
                }
            }
            //ResultSet Closed ????
            System.out.println("Username:" + result.getString("Username") + "   " + password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Did not log in successfully");
        return false;
    }
}
