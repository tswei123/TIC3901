public class Parser {

    public Command parse(String input){
        switch(input){
        case "1":
            return new Command("Add");

        default:
            return null;
        }

    }
}
