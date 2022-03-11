public class EditCommand extends Command {

    String action;

    public EditCommand(String action){
        setAction(action);
    }

    public void execute(UI ui, Diary diary){
        if(!diary.isDiaryEmpty()){
            diary.showDiaryList();
            System.out.print("Select No. from list to edit: ");
            String command = ui.readExecuteCommand();
            Integer editIndex = Integer.parseInt(command);  // throws exception if not in

            ui.breakLine();
        }
        else{
            System.out.println("Diary is empty!");
        }
    }

}
