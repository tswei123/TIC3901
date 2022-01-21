public class EditCommand extends Command {

    String action;

    public EditCommand(String action){
        setAction(action);
    }

    public void execute(UI ui, Diary diary){
        diary.showDiaryList();
        System.out.print("Select No. from list to edit: ");
        String editNumber = ui.readCommand();
        ui.breakLine();
    }

}
