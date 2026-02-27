package exception;

/**
 * The base exception class for all custom exceptions in the Kitten application.
 * It extends the standard {@code Exception} class and adds a suggestion field
 * to provide users with actionable advice on how to fix the error.
 */
public class KittenException extends Exception {
    private final String suggestion;

    /**
     * Constructs a KittenException with a specific error message and a suggestion.
     *
     * @param message The technical or descriptive error message.
     * @param suggestion A string providing guidance on how the user can resolve the error.
     */
    public KittenException(String message, String suggestion) {
        super(message);
        this.suggestion = suggestion;
    }

    ;

    /**
     * Retrieves the suggestion associated with this exception.
     *
     * @return The suggestion string.
     */
    public String getSuggestion() {
        return suggestion;
    }
}
