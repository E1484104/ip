package task;

import exception.InvalidTaskIndexException;

import java.util.ArrayList;

/**
 * Manages the collection of tasks in the application.
 * This class provides methods to add, delete, and modify tasks while
 * maintaining the integrity of the task counter.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with an existing list of tasks.
     *
     * @param tasks An ArrayList of tasks to initialize the TaskList.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list and updates the global task counter.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        Task.setNumberOfTasks(tasks.size());
    }

    /**
     * Removes a task from the list based on its 1-based index.
     *
     * @param index The 1-based index of the task to be removed.
     * @return The task that was removed.
     * @throws InvalidTaskIndexException If the index is out of bounds.
     */
    public Task deleteTask(int index) throws InvalidTaskIndexException {
        checkIndex(index);
        Task removedTask = tasks.remove(index - 1);
        Task.setNumberOfTasks(tasks.size());
        return removedTask;
    }

    /**
     * Marks the task at the specified 1-based index as completed.
     *
     * @param index The 1-based index of the task.
     * @return The task that was marked.
     * @throws InvalidTaskIndexException If the index is out of bounds.
     */
    public Task markTask(int index) throws InvalidTaskIndexException {
        checkIndex(index);
        Task t = tasks.get(index - 1);
        t.markAsDone();
        return t;
    }

    /**
     * Marks the task at the specified 1-based index as not completed.
     *
     * @param index The 1-based index of the task.
     * @return The task that was unmarked.
     * @throws InvalidTaskIndexException If the index is out of bounds.
     */
    public Task unmarkTask(int index) throws InvalidTaskIndexException {
        checkIndex(index);
        Task t = tasks.get(index - 1);
        t.markAsUndone();
        return t;
    }

    /**
     * Validates if the given 1-based index exists in the current list.
     *
     * @param index The index to check.
     * @throws InvalidTaskIndexException If the index is less than 1 or greater than list size.
     */
    private void checkIndex(int index) throws InvalidTaskIndexException {
        if (index <= 0 || index > tasks.size()) {
            throw new InvalidTaskIndexException();
        }
    }

    /**
     * Retrieves the internal list of tasks.
     *
     * @return The ArrayList containing the tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks currently in the list.
     *
     * @return The size of the task list.
     */
    public int getSize() {
        return tasks.size();
    }
}
