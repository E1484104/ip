package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;
import exception.KittenException;
import java.io.IOException;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException {
        Task removedTask = tasks.deleteTask(index);
        ui.printDeleteSuccess(removedTask, tasks);
        storage.save(tasks.getTasks());
    }
}