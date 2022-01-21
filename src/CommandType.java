public enum CommandType {

    EXIT("0"),
    ADD("1"),
    DELETE("2"),
    EDIT("3")
    ;

    private String commandType;

    CommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandType() {
        return commandType;
    }

    public static CommandType getCommandType(String inputAction)  {
        for (CommandType command : CommandType.values()) {
            if (command.getCommandType().equals(inputAction)) {
                return command;
            }
        }
        assert false;
        return null;
    }
}
