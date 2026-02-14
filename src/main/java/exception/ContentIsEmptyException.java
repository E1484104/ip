package exception;

public class ContentIsEmptyException extends KittenException {
    public ContentIsEmptyException(String message) {
        super("[EmptyContent] Description of " + message + " cannot be empty.",
                """
                Try: Follow formats listed below
                           todo [description]
                           deadline [description] /by [deadline]
                           event [description] /from [startTime] /to [endTime]""");
    }
}
