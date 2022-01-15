import java.util.Scanner;

public class main {

    //testing1
    //testing123
    public static void main(String[] args){
        System.out.print("Please enter your username: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();

        Launcher DiaryLauncher = new Launcher(username);

    }

}
