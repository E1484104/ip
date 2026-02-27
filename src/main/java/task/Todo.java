package task;

/**
 * Represents a basic task without any specific date or time constraints.
 * It serves as the base for more complex task types like {@code Deadline} and {@code Event}.
 */
public class Todo extends Task {
    protected String taskType;

    /**
     * Constructs a Todo task with a description and a task type label.
     *
     * @param description The content of the task.
     * @param taskType The character label for the task.
     */
    public Todo(String description, String taskType) {
        super(description);
        this.taskType = taskType;
    }

    /**
     * Gets the character label of the task type.
     *
     * @return The task type string.
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Returns a string representation of the Todo task, including its type label,
     * status icon, and description.
     *
     * @return A formatted string for display in the UI.
     */
    @Override
    public String toString() {
        return ("[" + taskType + "]" + super.toString());
    }

    /**
     * Returns the Todo task in a specific format for file storage.
     * The format follows: T | status | description.
     *
     * @return A formatted string suitable for saving to a data file.
     */
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
