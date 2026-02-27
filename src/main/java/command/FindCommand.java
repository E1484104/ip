package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a command to search for tasks within the task list.
 * The search is performed by checking if the task descriptions contain
 * the specified target keyword, case-insensitively.
 */
public class FindCommand extends Command {
    private String target;

    /**
     * Constructs a FindCommand with the specified search keyword.
     *
     * @param target The keyword to search for in task descriptions.
     */
    public FindCommand(String target) {
        this.target = target;
    }

    /**
     * Executes the search by iterating through the task list, collecting tasks that
     * match the keyword along with their original indices, and displaying them via the UI.
     *
     * @param tasks The task list to search through.
     * @param ui The user interface used to display the search results.
     * @param storage The storage component (not used in this read-only command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Integer> taskIndexes = new ArrayList<>();
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (int i = 0; i < tasks.getSize(); i++) {
            Task t = tasks.getTasks().get(i);
            if (t.getDescription().toLowerCase().contains(target.toLowerCase())) {
                foundTasks.add(t);
                taskIndexes.add(i + 1);
            }
        }

        ui.printFoundTasks(foundTasks, taskIndexes);
    }
}
