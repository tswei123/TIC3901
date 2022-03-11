public class ExitCommand extends Command {

    String action;

    public ExitCommand(String action){
        setAction(action);
    }

    public boolean isExit() {
        return true;
    }


}
