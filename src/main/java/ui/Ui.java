package ui;

import exception.KittenException;
import task.Task;
import task.TaskList;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner in;

    public static final String DIALOGUE_DIVIDER = "    ____________________________________________________________\n";
    public static final String OUTPUT_INDENTATION = "     ";
    public static final String SECOND_LINE_INDENTATION = "        ";

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String readCommand() {
        return in.nextLine().trim();
    }

    public void separateLine() {
        System.out.println(DIALOGUE_DIVIDER);
    }

    public void printWelcomeMessage() {
        System.out.print(DIALOGUE_DIVIDER);
        System.out.println(OUTPUT_INDENTATION + "Hey! I'm Kitten~ Good to see you again!");
        System.out.println(OUTPUT_INDENTATION + "What can I do for you? I'm always here to be with you~");
        System.out.println(DIALOGUE_DIVIDER);
    }

    public void printByeMessage() {
        System.out.println(OUTPUT_INDENTATION + "Bye~ Have a nice day and all the best!");
    }

    public void printTaskList(TaskList tasks) {
        System.out.println(OUTPUT_INDENTATION + "Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println("     " + (i + 1) + ". " + tasks.getTasks().get(i));
        }
    }

    public void printAddSuccess(Task task, String type, TaskList tasks) {
        System.out.println(OUTPUT_INDENTATION + "Got it! " + type + " task added: ");
        System.out.println(SECOND_LINE_INDENTATION + task);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + tasks.getSize() + " tasks in the list.");
    }

    public void printDeleteSuccess(Task task, TaskList tasks) {
        System.out.println(OUTPUT_INDENTATION + "Okay~ I've removed this task from your list:");
        System.out.println(SECOND_LINE_INDENTATION + task);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + tasks.getSize() + " tasks in the list.");
    }

    public void printMarkSuccess(Task task) {
        System.out.println(OUTPUT_INDENTATION + "Good job, have a rest! I've marked this task as done:");
        System.out.println(SECOND_LINE_INDENTATION + task);
    }

    public void printUnmarkSuccess(Task task) {
        System.out.println(OUTPUT_INDENTATION + "All right, I've marked this task as not done yet:");
        System.out.println(SECOND_LINE_INDENTATION + task);
    }

    public void printFoundTasks(ArrayList<Task> foundTasks, ArrayList<Integer> taskIndexes) {
        if (foundTasks.isEmpty()) {
            System.out.println(OUTPUT_INDENTATION + "I couldn't find any matching tasks :(");
        } else {
            System.out.println(OUTPUT_INDENTATION + "Here are the matching tasks in your list:");
            for (int i = 0; i < foundTasks.size(); i++) {
                int originalIdx = taskIndexes.get(i);
                System.out.println(OUTPUT_INDENTATION + originalIdx + "." + foundTasks.get(i));
            }
        }
    }

    public void showError(String message) {
        System.out.println(OUTPUT_INDENTATION + message);
    }

    public void showSuggestion(String suggestion){
        System.out.println(SECOND_LINE_INDENTATION + suggestion);
    }
}
