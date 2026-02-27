package task;

/**
 * Represents the abstract base class for all types of tasks in the application.
 * It contains the common properties of a task, such as its description and completion status,
 * as well as a static counter to track the total number of task instances created.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    private static int numberOfTasks = 0;

    /**
     * Gets the description of the task.
     *
     * @return The task description string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the task is completed.
     *
     * @return True if the task is done, false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the total count of tasks created.
     *
     * @return The static count of tasks.
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Manually updates the static task counter.
     *
     * @param numberOfTasks The new count to be set.
     */
    public static void setNumberOfTasks(int numberOfTasks) {
        Task.numberOfTasks = numberOfTasks;
    }

    /**
     * Constructs a new Task with the given description.
     * The completion status is initialized to false, and the task counter is incremented.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
    }

    /**
     * Marks the task status as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Reverts the task status to incomplete.
     */
    public void markAsUndone() {
        isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns the task in a formatted string suitable for saving to a file.
     * This method must be implemented by subclasses to include specific fields.
     *
     * @return A formatted string representing the task for file storage.
     */
    public abstract String toFileFormat();

    /**
     * Returns a string representation of the task for display in the UI.
     *
     * @return A string formatted as "[Status] Description".
     */
    @Override
    public String toString() {
        return ("[" + getStatusIcon() + "] " + description);
    }
}
