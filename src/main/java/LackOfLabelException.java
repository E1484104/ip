public class LackOfLabelException extends KittenException{
    public LackOfLabelException(String message){
        super("[LackOfLabel]" + message + " label is required in this kind of task.");
    }
}
