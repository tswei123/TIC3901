public class AddCommand extends Command {

    public AddCommand(String action) {
        setAction(action);
    }

    public void execute(UI ui, Diary diary) {
        diary.addEntry();
        ui.breakLine();
    }

}
