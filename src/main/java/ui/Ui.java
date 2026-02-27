package ui;

import exception.KittenException;
import task.Task;
import task.TaskList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the user interface of the application.
 * This class is responsible for reading user input and displaying messages,
 * including errors, task updates, and the welcome/goodbye sequences.
 */
public class Ui {
    private Scanner in;

    public static final String DIALOGUE_DIVIDER = "    ____________________________________________________________\n";
    public static final String OUTPUT_INDENTATION = "     ";
    public static final String SECOND_LINE_INDENTATION = "        ";

    /**
     * Initializes the Ui object by setting up a Scanner to read from the standard input.
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads a line of text entered by the user.
     *
     * @return The trimmed string of user input.
     */
    public String readCommand() {
        return in.nextLine().trim();
    }

    /**
     * Prints a divider line to separate different command outputs.
     */
    public void separateLine() {
        System.out.println(DIALOGUE_DIVIDER);
    }

    /**
     * Displays the welcome message when the application starts.
     */
    public void printWelcomeMessage() {
        System.out.print(DIALOGUE_DIVIDER);
        System.out.println(OUTPUT_INDENTATION + "Hey! I'm Kitten~ Good to see you again!");
        System.out.println(OUTPUT_INDENTATION + "What can I do for you? I'm always here to be with you~");
        System.out.println(DIALOGUE_DIVIDER);
    }

    /**
     * Displays the farewell message when the user exits the application.
     */
    public void printByeMessage() {
        System.out.println(OUTPUT_INDENTATION + "Bye~ Have a nice day and all the best!");
    }

    /**
     * Prints all tasks currently in the task list.
     *
     * @param tasks The TaskList containing tasks to be displayed.
     */
    public void printTaskList(TaskList tasks) {
        System.out.println(OUTPUT_INDENTATION + "Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println("     " + (i + 1) + ". " + tasks.getTasks().get(i));
        }
    }

    /**
     * Confirms the successful addition of a task.
     *
     * @param task The task that was added.
     * @param type The type of task added (e.g., Todo, Deadline).
     * @param tasks The updated TaskList to show the new total count.
     */
    public void printAddSuccess(Task task, String type, TaskList tasks) {
        System.out.println(OUTPUT_INDENTATION + "Got it! " + type + " task added: ");
        System.out.println(SECOND_LINE_INDENTATION + task);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + tasks.getSize() + " tasks in the list.");
    }

    /**
     * Confirms the successful deletion of a task.
     *
     * @param task The task that was removed.
     * @param tasks The updated TaskList to show the new total count.
     */
    public void printDeleteSuccess(Task task, TaskList tasks) {
        System.out.println(OUTPUT_INDENTATION + "Okay~ I've removed this task from your list:");
        System.out.println(SECOND_LINE_INDENTATION + task);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + tasks.getSize() + " tasks in the list.");
    }

    /**
     * Confirms that a task has been marked as completed.
     *
     * @param task The task that was marked as done.
     */
    public void printMarkSuccess(Task task) {
        System.out.println(OUTPUT_INDENTATION + "Good job, have a rest! I've marked this task as done:");
        System.out.println(SECOND_LINE_INDENTATION + task);
    }

    /**
     * Confirms that a task has been marked as incomplete.
     *
     * @param task The task that was unmarked.
     */
    public void printUnmarkSuccess(Task task) {
        System.out.println(OUTPUT_INDENTATION + "All right, I've marked this task as not done yet:");
        System.out.println(SECOND_LINE_INDENTATION + task);
    }

    /**
     * Displays a list of tasks that match a search keyword.
     *
     * @param foundTasks An ArrayList of tasks matching the keyword.
     * @param taskIndexes An ArrayList containing the original 1-based indices of those tasks.
     */
    public void printFoundTasks(ArrayList<Task> foundTasks, ArrayList<Integer> taskIndexes) {
        if (foundTasks.isEmpty()) {
            System.out.println(OUTPUT_INDENTATION + "I couldn't find any matching tasks :(");
        } else {
            System.out.println(OUTPUT_INDENTATION + "Here are the matching tasks in your list:");
            for (int i = 0; i < foundTasks.size(); i++) {
                int originalIdx = taskIndexes.get(i);
                System.out.println(OUTPUT_INDENTATION + originalIdx + ". " + foundTasks.get(i));
            }
        }
    }

    /**
     * Prints an error message to the console.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(OUTPUT_INDENTATION + message);
    }

    /**
     * Prints a suggestion or corrective action to the console.
     *
     * @param suggestion The hint or format guide to display.
     */
    public void showSuggestion(String suggestion) {
        System.out.println(SECOND_LINE_INDENTATION + suggestion);
    }
}
