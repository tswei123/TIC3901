public class Launcher {
    private UI ui;
    private Parser Parser;
    private CommandList commandList;
    private Diary diary;

    public Launcher(String username){
        ui = new UI();
        Parser = new Parser();
        commandList = new CommandList();
        diary = new Diary(username);
        run();
    }

    public void run(){
        boolean isExit = false;
        ui.printIntroduction();

        while (!isExit){
            try{
                commandList.printCommands();
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);

                System.out.print( "Command read: " );
                c.printCommand();
                c.execute(ui,diary);
                if (c.isExit()){
                    isExit = true;
                }

            } catch (Exception e){
                ui.showError("nothing");
                //ui.showError(e.getMessage());
            }

        }


    }
}
