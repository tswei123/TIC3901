import java.util.Scanner;

public class UI {
    private final String INTRODUCTION = "Hello. Welcome to our project.";
    private final String SUCCESS = "Command was successfully executed";

    public void printIntroduction() {
        System.out.println(INTRODUCTION);
    }

    public void printSuccess() {
        System.out.println(SUCCESS);
    }

    public void breakLine() {
        System.out.print("\n\n\n");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
