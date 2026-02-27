package exception;

/**
 * Exception thrown when the user enters a command that the system does not recognize.
 * This occurs when the initial keyword of the input does not match any valid command type.
 */
public class InvalidCommandException extends KittenException {
    /**
     * Constructs an InvalidCommandException with a default error message
     * and a list of valid commands as a suggestion for the user.
     */
    public InvalidCommandException() {
        super("[InvalidType] Command cannot be identified.",
                """
                        Try: Choose one of the command types listed below:
                                   todo / deadline / event / list / mark / unmark / delete / find / bye""");
    }
}
