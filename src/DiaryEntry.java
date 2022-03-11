import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DiaryEntry {
    protected String title;
    protected String body;
    protected String date;
    protected User user;
    protected int entryID;

    public DiaryEntry(User user, int entryID) {
        askTitle();
        askBody();
        askDate();
        setUser(user);
        setEntryID(entryID);
        printEntry(); //for checking
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public int getEntryID() {
        return entryID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date.toString();
    }

    public void modifyEntry(String title, String body, String date) {
        setTitle(title);
        setBody(body);
        setDate(date);
    }

    public void askTitle() {
        System.out.println("Please enter your entry title. ");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        setTitle(title);
    }

    public void askBody() {
        System.out.println("Please enter your entry body. ");
        Scanner in = new Scanner(System.in);
        String body = in.nextLine();
        setBody(body);
    }

    public void askDate() {
        System.out.println("Please enter your entry date. ");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        setDate(date);
    }

    public void printEntry() {
        printTitle();
        printBody();
        System.out.print("Added on: ");
        printDate();
    }

    public void printTitle() {
        System.out.println(title);
    }

    public void printBody() {
        System.out.println(body);
    }

    public void printDate() {
        System.out.println(date + "\n");
    }

    public void printList() {
        System.out.println(title + " | " + date);
    }

    public void printUser() {
        System.out.println(user.getUsername());
    }

}
