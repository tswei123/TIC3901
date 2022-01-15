import java.util.ArrayList;
import java.time.LocalDate;

public class Diary {
    public static String title;
    public static ArrayList<String> body;
    public static LocalDate date;
    private static String user;

    public Diary(){
        setDate(LocalDate.now());
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setBody(String entry){
        this.body.add(entry);
    }
}
