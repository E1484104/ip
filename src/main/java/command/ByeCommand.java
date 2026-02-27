package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;

/**
 * Represents a command to terminate the program.
 * When executed, it triggers the exit sequence and signals the main loop to stop.
 */
public class ByeCommand extends Command {

    /**
     * Executes the command by displaying the goodbye message to the user.
     *
     * @param tasks The list of tasks (not modified by this command).
     * @param ui The user interface to display the farewell message.
     * @param storage The storage component (not modified by this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printByeMessage();
    }

    /**
     * Indicates that this command will cause the application to terminate.
     *
     * @return Always returns true to signal the end of the program.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
