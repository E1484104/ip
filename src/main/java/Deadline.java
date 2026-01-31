public class Deadline extends Todo{
    protected String by;

    public Deadline(String description, String taskType, String by){
        super(description, taskType);
        this.by = by;
    }

    @Override
    public String toString(){
        return (super.toString() + " (by: " + by + ")");
    }
}
