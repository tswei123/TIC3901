import java.util.ArrayList;

public class CommandList {
    private ArrayList<String> commandsList;
    public CommandList(){
        commandsList = new ArrayList<>();
        //Add all commands here
        commandsList.add("Add");
        commandsList.add("Delete");
        commandsList.add("View");
    }

    public void printCommands(){
        System.out.println("Select from commands (1 to " + commandsList.size() + ") to execute action.");
        for (int i = 0; i < commandsList.size(); i++){
            printCounter(i);
            System.out.println(commandsList.get(i));
        }
        System.out.print("Please enter command: ");
    }
    public void printCounter(int counter){
        System.out.print( counter + 1 + ". ");
    }

}
