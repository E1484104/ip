package exception;

/**
 * Exception thrown when a command is provided with empty required content.
 * This typically occurs when a task description or a required field (like /by, /from, /to)
 * is missing from the user input.
 */
public class ContentIsEmptyException extends KittenException {
    /**
     * Constructs a ContentIsEmptyException with a specific message indicating which
     * part of the command was empty, along with a suggested format guide.
     *
     * @param message The name of the field or task type that was found to be empty.
     */
    public ContentIsEmptyException(String message) {
        super("[EmptyContent] Description of " + message + " cannot be empty.",
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
