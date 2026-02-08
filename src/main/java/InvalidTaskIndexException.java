public class InvalidTaskIndexException extends KittenException{
    public InvalidTaskIndexException(){
        super("[InvalidIndex] This index is out of our list range.");
    }
}
