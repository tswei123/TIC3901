
public class Parser {

    public Command parse(String input){
        CommandType commandType = CommandType.getCommandType(input);
        switch(commandType){
        case ADD:
            return new AddCommand("Add");

        case DELETE:
            return new DeleteCommand("Delete");

        case VIEW:
            return new ViewCommand("View");

        case EXIT:
            return new ExitCommand("Exit");

        default:
            System.out.println("Unrecognized command input.");
            return null; //replace all null with error exceptions
        }

    }
}
