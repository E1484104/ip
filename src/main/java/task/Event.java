package task;

/**
 * Represents a task that occurs during a specific time period.
 * An Event task includes a description, a start time, and an end time.
 */
public class Event extends Todo {
    protected String from;
    protected String to;

    /**
     * Constructs an Event task with the specified description, type, start time, and end time.
     *
     * @param description The content of the event.
     * @param taskType The character representing the task type (e.g., "E").
     * @param from The starting time/date of the event.
     * @param to The ending time/date of the event.
     */
    public Event(String description, String taskType, String from, String to) {
        super(description, taskType);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task, including its
     * status icon, description, and time duration.
     *
     * @return A formatted string for display in the UI.
     */
    @Override
    public String toString() {
        return (super.toString() + " (from: " + from + " to: " + to + ")");
    }

    /**
     * Returns the event task in a specific format for file storage.
     * The format follows: E | status | description | from | to.
     *
     * @return A formatted string suitable for saving to a data file.
     */
    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }

}
