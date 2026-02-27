package exception;

/**
 * Exception thrown when a user provides a task index that does not exist in the current task list.
 * This occurs when the index is less than 1 or greater than the current size of the list.
 */
public class InvalidTaskIndexException extends KittenException {
    /**
     * Constructs an InvalidTaskIndexException with a specific message indicating
     * the index is out of range and suggesting the user verify the list first.
     */
    public InvalidTaskIndexException() {
        super("[InvalidIndex] This index is out of our list range.",
                "Try: Check task list and re-input a valid index");
    }
}
