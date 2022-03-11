import java.io.File;

public class User {
    public String username;
    public String password;
    public String path;
    public String absolutePath;
    private Connect databaseConnection;

    public User(String username){
        setUsername(username);
        password = "123";
        setPath();
        //try load file first.
        newFile();
        databaseConnection = new Connect(absolutePath);
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
            setAbsolutePath(f.getAbsolutePath());
            if (f.createNewFile())
                System.out.println("New file created.");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void insertEntry(DiaryEntry entry){
        String title,body,date;
        int entryID;

        entryID = entry.getEntryID();
        title = entry.getTitle();
        body = entry.getBody();
        date = entry.getDate();
        databaseConnection.insertEntryDB(entryID,title,body,date);
    }

    public void deleteEntry(int entryID){
        databaseConnection.deleteEntryDB(entryID);
    }

    public void saveFile(){

    }
}
