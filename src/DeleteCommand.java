import java.awt.*;

public class DeleteCommand extends Command {

    public DeleteCommand(String action) {
        setAction(action);
    }

    public void execute(UI ui, Diary diary) {
        if (!diary.isDiaryEmpty()) {
            diary.showDiaryList();
            System.out.print("Select No. from list to delete: ");
            String command = ui.readCommand();
            Integer deleteIndex = Integer.parseInt(command);  // throws exception if not int

            diary.showEntry(deleteIndex - 1);
            System.out.println("Are you sure you want to delete the entry? ");
            System.out.println("Enter 'yes' to continue: ");
            String confirmCommand = ui.readCommand();
            if (confirmCommand.equals("yes")){
                diary.deleteEntry(deleteIndex - 1);
                ui.printSuccess();
            }
            ui.breakLine();
        } else {
            System.out.println("Diary is empty!");
        }

    }

}
