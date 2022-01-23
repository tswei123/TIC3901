import java.awt.*;

public class DeleteCommand extends Command {

    String action;

    public DeleteCommand(String action){
        setAction(action);
    }

    public void execute(UI ui, Diary diary){
        if(!diary.isDiaryEmpty()){
            diary.showDiaryList();
            System.out.print("Select No. from list to delete: ");
            String command = ui.readExecuteCommand();
            Integer deleteIndex = Integer.parseInt(command);  // throws exception if not int
            diary.deleteEntry(deleteIndex - 1);

            ui.breakLine();
        }
        else{
            System.out.println("Diary is empty!");
        }

    }

}
