package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;
import exception.KittenException;

import java.io.IOException;

/**
 * Represents a command to mark a specific task in the task list as not completed.
 * This command reverts the status of a task that was previously marked as done.
 */
public class UnmarkCommand extends Command {
    private int index;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param index The 1-based index of the task to be marked as not done.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by updating the task's status to incomplete,
     * displaying the success message, and saving the changes to storage.
     *
     * @param tasks The task list containing the task to be unmarked.
     * @param ui The user interface to handle output messages.
     * @param storage The storage component used to persist the updated task list.
     * @throws KittenException If the provided index is out of the task list bounds.
     * @throws IOException If an error occurs while saving the task list to the file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException {
        Task t = tasks.unmarkTask(index);
        ui.printUnmarkSuccess(t);
        storage.save(tasks.getTasks());
    }
}
