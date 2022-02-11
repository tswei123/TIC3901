import java.io.File;

public class User {
    public String username;
    public String password;
    public String path;

    public User(String username){
        setUsername(username);
        password = "123";
        setPath();
        //try load file first.
        newFile();
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
    public void setPath(){
        path = "database/" + username + ".db";
    }

    public String getPath(){
        return path;
    }

    public void newFile(){
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();

            if (f.createNewFile())
                System.out.println("New file created.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
