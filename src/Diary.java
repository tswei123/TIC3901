public class Diary {
    private UI ui;
    private Commands commands;

    public Diary(){
        try{
            ui = new UI();
            commands = new Commands();

            ui.printIntroduction();
            commands.printCommands();
        } catch (Exception e){
            ui.showError("nothing");
           //ui.showError(e.getMessage());
        }


    }

}
