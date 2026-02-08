public class KittenException extends Exception{
    private final String suggestion;

    public KittenException(String message, String suggestion){
        super(message);
        this.suggestion = suggestion;
    };

    public String getCorrection() {
        return suggestion;
    }
}
