package exception;

public class LackOfLabelException extends KittenException{
    public LackOfLabelException(String message){
        super("[LackOfLabel] " + message + " label is required in this kind of task.",
                """
                Try: Follow formats listed below
                           todo [description]
                           deadline [description] /by [deadline]
                           event [description] /from [startTime] /to [endTime]
                           mark [taskIndex]
                           unmark [taskIndex]
                           delete [taskIndex]""");
    }
}
