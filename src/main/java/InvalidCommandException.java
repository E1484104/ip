public class InvalidCommandException extends KittenException{
    public InvalidCommandException(){
        super("[InvalidType] Choose one of the three task types listed: todo / deadline / event");
    }
}
