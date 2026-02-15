package task;

public class Todo extends Task{
    protected String taskType;
    public Todo(String description, String taskType){
        super(description);
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String toString(){
        return ("[" + taskType + "]" + super.toString());
    }

    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
