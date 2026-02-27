package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;

import java.io.IOException;

/**
 * Represents a command to add a task to the task list.
 * This class handles the execution logic for adding Todo, Deadline, and Event tasks.
 */
public class AddCommand extends Command {
    private Task task;
    private String type;

    /**
     * Constructs an AddCommand with the specified task and its type.
     *
     * @param task The task object to be added.
     * @param type The string representation of the task type (e.g., "todo", "deadline").
     */
    public AddCommand(Task task, String type) {
        this.task = task;
        this.type = type;
    }

    /**
     * Executes the command by adding the task to the list, displaying a success message,
     * and saving the updated list to storage.
     *
     * @param tasks The list of tasks where the new task will be added.
     * @param ui The user interface to handle output messages.
     * @param storage The storage component to persist the updated task list.
     * @throws IOException If an error occurs while saving the task list to the file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        tasks.addTask(task);
        ui.printAddSuccess(task, type, tasks);
        storage.save(tasks.getTasks());
    }
}
