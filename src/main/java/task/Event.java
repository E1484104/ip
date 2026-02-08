package task;

public class Event extends Todo{
    protected String from;
    protected String to;

    public Event(String description, String taskType, String from, String to){
        super(description, taskType);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString(){
        return (super.toString() + " (from: " + from + " to: " + to + ")");
    }

}
