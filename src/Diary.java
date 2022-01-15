import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Diary {
    public static ArrayList<DiaryEntry> diaryEntries;
    public static LocalDate date;
    private static String user;

    public Diary(String user){
        diaryEntries = new ArrayList<>();
        setDate(LocalDate.now());
        setUser(user);
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void addEntry(){
        diaryEntries.add(new DiaryEntry(user));
    }

    public void setUser(String user){
        this.user = user;
    }

    public void printUser(){
        System.out.println(user);
    }
}
