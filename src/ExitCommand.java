public class ExitCommand extends Command {

    String action;
    public ExitCommand() {

    }

    public ExitCommand(String action){
        setAction(action);
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isExit() {
        return true;
    }

    public void printCommand(){
        System.out.println(action);
    }

    public void execute(UI ui){

    }



}
