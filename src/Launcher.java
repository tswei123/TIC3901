import java.util.Scanner;

public class Launcher {
    private UI ui;
    private Parser Parser;
    private CommandList commandList;
    private Diary diary;

    public Launcher(User user) {
        ui = new UI();
        Parser = new Parser();
        commandList = new CommandList();
        diary = new Diary(user);
        user.loadDiary(diary);
        run();
    }

    public void run() {
        boolean isExit = false;
        ui.printIntroduction();

        while (!isExit) {
            try {
                commandList.printCommands();
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(ui, diary);
                if (c.isExit()) {
                    isExit = true;
                }

            } catch (Exception e) {
                ui.showError(e.getMessage());
            }

        }


    }
}
