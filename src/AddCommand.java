public class AddCommand extends Command {

    String action;

    public AddCommand(String action){
        setAction(action);
    }

    public void execute(UI ui, Diary diary){
        diary.addEntry();
    }

}
