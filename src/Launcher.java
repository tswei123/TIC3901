import java.util.Scanner;

public class Launcher {
    private UI ui;
    private Parser Parser;
    private CommandList commandList;
    private Diary diary;

    public Launcher(){
        ui = new UI();
        Parser = new Parser();
        commandList = new CommandList();

        System.out.print("Please enter your username: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        User user = new User(username);
        //Connect.connectToDb(username);
        diary = new Diary(user);
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
