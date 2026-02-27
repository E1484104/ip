package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.KittenException;

import java.io.IOException;

/**
 * An abstract base class for all executable commands in the Kitten application.
 * All specific command types (e.g., AddCommand, DeleteCommand) must inherit
 * from this class and implement the execute method.
 */
public abstract class Command {

    /**
     * Executes the specific logic of the command.
     *
     * @param tasks The task list to be manipulated or queried.
     * @param ui The user interface used to interact with the user.
     * @param storage The storage component used for reading or writing data.
     * @throws KittenException If a logical error occurs during execution.
     * @throws IOException If an I/O error occurs during task persistence.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException;

    /**
     * Returns whether this command signals the application to terminate.
     * By default, commands do not cause the program to exit.
     *
     * @return True if the application should exit, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
