
public class Parser {

    public Command parse(String input){
        CommandType commandType = CommandType.getCommandType(input);
        switch(commandType){
        case ADD:
            return new Command("Add");

        case DELETE:
            return new Command("Delete");

        case VIEW:
            return new Command("View");

        default:
            System.out.println("Unrecognized command input.");
            return null; //replace all null with error exceptions
        }

    }
}
