public class ContentIsEmptyException extends KittenException{
    public ContentIsEmptyException(String message){
        super("[EmptyContent] Description of " + message + " cannot be empty.");
    }
}
