import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DiaryEntry {
    protected String title;
    protected ArrayList<String> body;
    protected LocalDate date;
    protected User user;

    public DiaryEntry(){

    }
    public DiaryEntry(User user){
        body = new ArrayList<>();
        askTitle();
        askBody();
        setDate(LocalDate.now());
        setUser(user);
        printEntry(); //for checking
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setBody(ArrayList<String> body){
        this.body = body;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void askTitle(){
        System.out.println("Please enter entry your title. ");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        setTitle(title);
    }

    public void askBody(){

        Boolean isNewLine = true;
        while(isNewLine) {
            System.out.println("Please enter entry your body. ");
            Scanner in = new Scanner(System.in);
            String body = in.nextLine();
            addBody(body);

            System.out.println("New line? 'y' to continue ");
            Scanner in2 = new Scanner(System.in);
            String newLineResponse = in2.nextLine();
            if (!newLineResponse.equals("y")){
                isNewLine = false;
            }

        }
    }

    public void addBody(String body){
        this.body.add(body);
    }

    public void printEntry(){
        printTitle();
        printBody();
        System.out.print("Added on: ");
        printDate();
    }

    public void printTitle(){
        System.out.println(title);
    }

    public void printBody(){
        for (String body : this.body) {
            System.out.println(body + "\n" );
        }
    }

    public void printDate(){
        System.out.println(date + "\n");
    }

    public void printList(){
        System.out.println(title + " | " + date);
    }

    public void printUser(){
        System.out.println(user.getUsername());
    }

}
