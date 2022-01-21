public class ViewCommand extends Command {

    String action;

    public ViewCommand(String action){
        setAction(action);
    }

    public void execute(UI ui, Diary diary){
        diary.showDiaryList();
        ui.breakLine();
    }

}
