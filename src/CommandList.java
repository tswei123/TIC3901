import java.util.ArrayList;

public class CommandList {
    private ArrayList<String> commandsList;
    public CommandList(){
        commandsList = new ArrayList<>();
        //Add all commands here
        commandsList.add("Exit");
        commandsList.add("Add");
        commandsList.add("Delete");
        commandsList.add("Edit");
    }

    public void printCommands(){
        System.out.println("Select from commands (0 to " + (commandsList.size() - 1) + ") to execute action.");
        for (int i = 1; i < commandsList.size(); i++){
            printCounter(i);
            System.out.println(commandsList.get(i));
        }
        printExit();
        System.out.print("Please enter command: ");
    }
    public void printCounter(int counter){
        System.out.print( counter + ". ");
    }

    public void printExit(){
        printCounter(0);
        System.out.println(commandsList.get(0));
    }
}
