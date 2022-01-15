public abstract class Command {

    String action;
    public Command() {

    }

    public Command(String action){
        setAction(action);
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isExit() {
        return false;
    }

    public void printCommand(){
        System.out.println(action);
    }

    public void execute(UI ui, Diary diary){

    }



}
