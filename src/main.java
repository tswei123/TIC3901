import java.sql.Connection;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.print("Please enter your username: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine(); //placeholder until user class is complete
        System.out.print("Please enter your password: ");
        String password = in.nextLine();
        Login login = new Login(username, password);
        login.validate(username, password);
        User user = new User(username);

        Launcher DiaryLauncher = new Launcher(user);

    }

}
