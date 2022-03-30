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
        boolean checkUser = login.validate(username, password);
        if (checkUser == false){
            System.out.println("Did not log in successfully. You're not registered.");
            System.out.println("Would you like to be registered ? If yes, reply with 1.");
            String num = in.nextLine();
            if (num.equals("1")){
                System.out.println("Please enter your new Username: ");
                String usernameNew = in.nextLine();
                System.out.println("Please enter your Name: ");
                String nameNew = in.nextLine();
                System.out.println("Please enter your Email: ");
                String emailNew = in.nextLine();
                System.out.println("Please enter your Password: ");
                String passwordNew = in.nextLine();
                login.insertEntry(usernameNew, nameNew, emailNew, passwordNew);

                System.out.println("Congratulation! You're registered! ");
                User user = new User(usernameNew);
                Launcher DiaryLauncher = new Launcher(user);
            }
        }
        else{
            User user = new User(username);
            Launcher DiaryLauncher = new Launcher(user);
        }
    }
}
