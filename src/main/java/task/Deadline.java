package task;

/**
 * Represents a task with a specific deadline.
 * A Deadline task includes a description and a date/time by which the task must be completed.
 */
public class Deadline extends Todo {
    protected String by;

    /**
     * Constructs a Deadline task with the specified description, type, and deadline.
     *
     * @param description The content of the deadline task.
     * @param taskType    The character representing the task type (e.g., "D").
     * @param by          The deadline associated with the task.
     */
    public Deadline(String description, String taskType, String by) {
        super(description, taskType);
        this.by = by;
    }

    /**
     * Returns a string representation of the deadline task, including its
     * status icon, description, and deadline date.
     *
     * @return A formatted string for display in the UI.
     */
    @Override
    public String toString() {
        return (super.toString() + " (by: " + by + ")");
    }

    /**
     * Returns the deadline task in a specific format for file storage.
     * The format follows: D | status | description | by.
     *
     * @return A formatted string suitable for saving to a data file.
     */
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
