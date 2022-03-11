import java.util.Scanner;

public class UI {
    private final String INTRODUCTION = "Hello. Welcome to our project.";


    public void printIntroduction(){
        System.out.println(INTRODUCTION);
    }

    public void breakLine(){
        System.out.print("\n\n\n");
    }

    public void showError(String errorMessage){
        System.out.println("Not implemented yet");
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public String readExecuteCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
