package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;
import exception.KittenException;

import java.io.IOException;

/**
 * Represents a command to mark a specific task in the task list as completed.
 * The task is identified by its 1-based index provided by the user.
 */
public class MarkCommand extends Command {
    private int index;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param index The 1-based index of the task to be marked as done.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by marking the task as done, displaying a success message,
     * and saving the updated task list to storage.
     *
     * @param tasks The task list containing the task to be marked.
     * @param ui The user interface to handle output messages.
     * @param storage The storage component to persist the updated status.
     * @throws KittenException If the provided index is out of the task list bounds.
     * @throws IOException If an error occurs while saving the updated list to the file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException {
        Task t = tasks.markTask(index);
        ui.printMarkSuccess(t);
        storage.save(tasks.getTasks());
    }
}
