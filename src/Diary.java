public class Diary {
    private UI ui;
    private Parser Parser;
    private CommandList commandList;

    public Diary(){
        run();
    }

    public void run(){
        ui = new UI();
        Parser = new Parser();
        commandList = new CommandList();
        boolean isExit = false;
        ui.printIntroduction();

        while (!isExit){
            try{
                commandList.printCommands();
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);

                System.out.print( "Command read: " );
                c.printCommand();
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
