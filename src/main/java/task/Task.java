package task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    private static int numberOfTasks = 0;

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    public static void setNumberOfTasks(int numberOfTasks) {
        Task.numberOfTasks = numberOfTasks;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsUndone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public abstract String toFileFormat();

    @Override
    public String toString(){
        return ("[" + getStatusIcon() + "] " + description);
    }
}
