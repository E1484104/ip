package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;
import exception.KittenException;
import java.io.IOException;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException {
        Task t = tasks.unmarkTask(index);
        ui.printUnmarkSuccess(t);
        storage.save(tasks.getTasks());
    }
}
