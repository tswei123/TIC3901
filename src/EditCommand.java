import java.util.Scanner;

public class EditCommand extends Command {

    public EditCommand(String action) {
        setAction(action);
    }

    public void execute(UI ui, Diary diary) {
        String title, body, date;
        if (!diary.isDiaryEmpty()) {
            diary.showDiaryList();
            System.out.print("Select No. from list to edit: ");
            String command = ui.readCommand();
            Integer editIndex = Integer.parseInt(command);
            System.out.println("Please copy and paste the title and body to edit.");
            diary.showEntry(editIndex - 1);
            title = askTitle();
            body = askBody();
            date = askDate();
            System.out.println("Are you sure you want to edit the entry? ");
            System.out.println("Enter 'yes' to continue: ");
            String confirmCommand = ui.readCommand();
            if (confirmCommand.equals("yes")){
                diary.editEntry(editIndex - 1, title, body, date);
                ui.printSuccess();
            }
            ui.breakLine();
        } else {
            System.out.println("Diary is empty!");
        }
    }

    public String askTitle() {
        String title;
        System.out.println("Please enter your new entry title. ");
        title = readCommand();
        return title;
    }

    public String askBody() {
        String body;
        System.out.println("Please enter your new entry body. ");
        body = readCommand();
        return body;
    }

    public String askDate() {
        String date;
        System.out.println("Please enter your new entry date. ");
        date = readCommand();
        return date;
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
