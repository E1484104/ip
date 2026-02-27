package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;
import exception.KittenException;

import java.io.IOException;

/**
 * Represents a command to remove a task from the task list.
 * This command identifies the task to be deleted using its 1-based index
 * within the current task list.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructs a DeleteCommand with the specified index.
     *
     * @param index The 1-based index of the task to be deleted from the list.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command by removing the task at the specified index,
     * notifying the user of the success, and updating the storage file.
     *
     * @param tasks The task list from which the task will be removed.
     * @param ui The user interface to display the deletion confirmation.
     * @param storage The storage component to save the updated task list.
     * @throws KittenException If the provided index is out of bounds or invalid.
     * @throws IOException If an error occurs while saving the updated list to the file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException {
        Task removedTask = tasks.deleteTask(index);
        ui.printDeleteSuccess(removedTask, tasks);
        storage.save(tasks.getTasks());
    }
}