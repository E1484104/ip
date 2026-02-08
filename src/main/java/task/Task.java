package task;

public class Task {
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

    @Override
    public String toString(){
        return ("[" + getStatusIcon() + "] " + description);
    }
}
