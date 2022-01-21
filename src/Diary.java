import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Diary {
    public static ArrayList<DiaryEntry> diaryEntries;
    public static LocalDate date;
    private static User user;

    public Diary(User user){
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

    public void setUser(User user){
        this.user = user;
    }

    public void showDiaryList(){
        int count = 1;
        System.out.println("No.| Title     | Date");
        for (DiaryEntry entry : diaryEntries){
            System.out.print(count + ". | ");
            entry.printList();
            count++;
        }
    }

    public void printUser(){
        System.out.println(user);
    }
}
