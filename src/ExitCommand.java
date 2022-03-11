public class ExitCommand extends Command {

    String action;

    public ExitCommand(String action){
        setAction(action);
    }

    public void execute(UI ui, Diary diary){

    }

    public boolean isExit() {
        return true;
    }


}
