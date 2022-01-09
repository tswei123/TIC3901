import java.util.Scanner;

public class UI {
    private final String INTRODUCTION = "Hello. Welcome to our project.";


    public void printIntroduction(){
        System.out.println(INTRODUCTION);

    }

    public void showError(String errorMessage){
        System.out.println("Not implemented yet");
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
