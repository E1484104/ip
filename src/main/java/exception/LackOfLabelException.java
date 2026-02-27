package exception;

/**
 * Exception thrown when a command is missing required labels or delimiters.
 * This typically occurs when a user forgets to include specific keywords like
 * "/by" for deadlines or "/from" and "/to" for events.
 */
public class LackOfLabelException extends KittenException {
    /**
     * Constructs a LackOfLabelException with a specific message indicating
     * which label is missing and providing a format guide as a suggestion.
     *
     * @param message The name of the required label that was not found in the input.
     */
    public LackOfLabelException(String message) {
        super("[LackOfLabel] " + message + " label is required in this kind of task.",
                """
                        Try: Follow formats listed below
                                   todo [description]
                                   deadline [description] /by [deadline]
                                   event [description] /from [startTime] /to [endTime]
                                   mark [taskIndex]
                                   unmark [taskIndex]
                                   delete [taskIndex]
                                   find [targetContent]""");
    }
}
