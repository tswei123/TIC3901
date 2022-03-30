import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

    public HashMap<String, String> getUserDB(){
        HashMap<String, String> result = databaseConnection.loadUser();
        return result;
    }

    public boolean validate(String usernameUser, String passwordUser) {
        HashMap<String, String> result = getUserDB();
        for (Map.Entry mapElement : result.entrySet()){
            String username = (String)mapElement.getKey();
            String password = (String)mapElement.getValue();
            if(usernameUser.equals(username) && passwordUser.equals(password))
            {
                System.out.println("Successfully logged in");
                return true;
            }
        }
        return false;
    }

    public void insertEntry(String username, String name, String email, String password) {
        databaseConnection.insertUserDB(username, name, email, password);
    }
}
