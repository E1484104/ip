package task;

import exception.InvalidTaskIndexException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        Task.setNumberOfTasks(tasks.size());
    }

    public Task deleteTask(int index) throws InvalidTaskIndexException {
        checkIndex(index);
        Task removedTask = tasks.remove(index - 1);
        Task.setNumberOfTasks(tasks.size());
        return removedTask;
    }

    public Task markTask(int index) throws InvalidTaskIndexException {
        checkIndex(index);
        Task t = tasks.get(index - 1);
        t.markAsDone();
        return t;
    }

    public Task unmarkTask(int index) throws InvalidTaskIndexException {
        checkIndex(index);
        Task t = tasks.get(index - 1);
        t.markAsUndone();
        return t;
    }

    private void checkIndex(int index) throws InvalidTaskIndexException {
        if (index <= 0 || index > tasks.size()) {
            throw new InvalidTaskIndexException();
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getSize() {
        return tasks.size();
    }
}
