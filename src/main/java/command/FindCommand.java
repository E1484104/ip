package command;

import task.TaskList;
import task.Task;
import ui.Ui;
import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;

public class FindCommand extends Command {
    private String target;

    public FindCommand(String target) {
        this.target = target;
    }

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
