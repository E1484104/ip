package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;

/**
 * Represents a command to display all tasks currently in the task list.
 * This command retrieves the full list of tasks and formats them for output through the UI.
 */
public class ListCommand extends Command {
    /**
     * Executes the command by invoking the UI to print the entire list of tasks.
     *
     * @param tasks The task list containing all current tasks.
     * @param ui The user interface used to display the formatted list.
     * @param storage The storage component (not used in this read-only command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printTaskList(tasks);
    }
}