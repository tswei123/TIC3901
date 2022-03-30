import java.util.Scanner;

public class ViewCommand extends Command {

    public ViewCommand(String action) {
        setAction(action);
    }

    public void execute(UI ui, Diary diary) {
        String title, body, date;
        if (!diary.isDiaryEmpty()) {
            diary.showDiaryList();
            System.out.print("Select No. from list to view: ");
            String command = ui.readCommand();
            Integer editIndex = Integer.parseInt(command);
            diary.showEntry(editIndex - 1);
            System.out.println("Enter any key to to exit: ");
            String confirmCommand = ui.readCommand();
            ui.breakLine();
        } else {
            System.out.println("Diary is empty!");
        }
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
