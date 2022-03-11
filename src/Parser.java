
public class Parser {

    public Command parse(String input) throws Exception {
        try {
            CommandType commandType = CommandType.getCommandType(input);
            switch (commandType) {
            case ADD:
                return new AddCommand("Add");

            case DELETE:
                return new DeleteCommand("Delete");

            case EDIT:
                return new EditCommand("Edit");

            case EXIT:
                return new ExitCommand("Exit");

            default:
                return null;

            }
        } catch (Exception e) {
            throw new Exception("Unrecognized command input");
        }
    }
}

