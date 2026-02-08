public class InvalidCommandException extends KittenException{
    public InvalidCommandException(){
        super("[InvalidType] Command cannot be identified.",
                "Try: Choose one of the command types listed: todo / deadline / event / list / mark / unmark / bye");
    }
}
