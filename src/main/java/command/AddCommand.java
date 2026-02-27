package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;
import java.io.IOException;

public class AddCommand extends Command{
    private Task task;
    private String type;

    public AddCommand(Task task, String type) {
        this.task = task;
        this.type = type;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        tasks.addTask(task);
        ui.printAddSuccess(task, type, tasks);
        storage.save(tasks.getTasks());
    }
}
