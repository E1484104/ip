package ui;

import exception.ContentIsEmptyException;
import exception.InvalidCommandException;
import exception.InvalidTaskIndexException;
import exception.KittenException;
import exception.LackOfLabelException;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.Scanner;
import java.util.ArrayList;

public class Kitten {

    public static final String DIALOGUE_DIVIDER = "    ____________________________________________________________\n";
    public static final String OUTPUT_INDENTATION = "     ";
    public static final String SECOND_LINE_INDENTATION = "        ";
    public static final int TODO_PREFIX_LENGTH = 4;
    public static final int DEADLINE_PREFIX_LENGTH = 8;
    public static final int BY_PREFIX_LENGTH = 3;
    public static final int EVENT_PREFIX_LENGTH = 5;
    public static final int FROM_PREFIX_LENGTH = 5;
    public static final int TO_PREFIX_LENGTH = 3;
    public static final int MARK_PREFIX_LENGTH = 4;
    public static final int UNMARK_PREFIX_LENGTH = 6;
    public static final int DELETE_PREFIX_LENGTH = 6;
    public static final String NON_NUMERICAL_INDEX_EXCEPTION_REPORT = "[NonNumericalIndex] The index cannot be interpreted into numerical values.";
    public static final String NON_NUMERICAL_INDEX_EXCEPTION_SOLUTION = "Try: Input a numerical task index";

    public static void main(String[] args) {
        printWelcomeMessage();
        handleCommand();
        printByeMessage();
    }

    private static void handleCommand() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();

        ArrayList<Task> tasks = new ArrayList<>();

        while (!line.equals("bye")) {
            try {
                if (line.equals("list")) {
                    handleCommandList(tasks);
                } else if (line.startsWith("mark")) {
                    handleCommandMark(line, tasks);
                } else if (line.startsWith("unmark")) {
                    handleCommandUnmark(line, tasks);
                } else if (line.startsWith("todo")) {
                    handleCommandTodo(line, tasks);
                } else if (line.startsWith("deadline")) {
                    handleCommandDeadline(line, tasks);
                } else if (line.startsWith("event")) {
                    handleCommandEvent(line, tasks);
                } else if (line.startsWith("delete")) {
                    handleCommandDelete(line, tasks);
                } else {
                    throw new InvalidCommandException();
                }
            } catch (KittenException e) {
                System.out.println(OUTPUT_INDENTATION + e.getMessage());
                System.out.println(SECOND_LINE_INDENTATION + e.getSuggestion());
            }

            System.out.println(DIALOGUE_DIVIDER);

            line = in.nextLine().trim();
        }
    }

    private static void handleCommandDelete(String line, ArrayList<Task> tasks) throws KittenException {
        line = line.substring(DELETE_PREFIX_LENGTH).trim();

        checkEmpty(line, "delete index");

        try {
            int thisIndex = Integer.parseInt(line);

            checkIndex(thisIndex);

            Task t = tasks.get(thisIndex - 1);
            tasks.remove(thisIndex - 1);
            Task.setNumberOfTasks(Task.getNumberOfTasks() - 1);
            System.out.println(OUTPUT_INDENTATION + "Okay~ I've removed this task from your list: ");
            System.out.println(SECOND_LINE_INDENTATION + t);
            System.out.println(OUTPUT_INDENTATION + "Now you have " + Task.getNumberOfTasks() + " tasks in the list.");
        } catch (NumberFormatException e) {
            throw new KittenException(NON_NUMERICAL_INDEX_EXCEPTION_REPORT, NON_NUMERICAL_INDEX_EXCEPTION_SOLUTION);
        }
    }

    private static void handleCommandEvent(String line, ArrayList<Task> tasks) throws KittenException {
        checkLabel(line, "/from");
        checkLabel(line, "/to");

        int fromIndex = line.indexOf("/from");
        int toIndex = line.indexOf("/to");
        String description = line.substring(EVENT_PREFIX_LENGTH, fromIndex).trim();
        String from = line.substring(fromIndex + FROM_PREFIX_LENGTH, toIndex).trim();
        String to = line.substring(toIndex + TO_PREFIX_LENGTH).trim();

        checkEmpty(description, "event task content");
        checkEmpty(from, "/from label content");
        checkEmpty(to, "/to label content");

        Task t = new Event(description, "E", from, to);
        tasks.add(t);
        System.out.println(OUTPUT_INDENTATION + "Got it! Event task added: ");
        System.out.println(SECOND_LINE_INDENTATION + t);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + Task.getNumberOfTasks() + " tasks in the list.");
    }

    private static void handleCommandDeadline(String line, ArrayList<Task> tasks) throws KittenException {
        checkLabel(line, "/by");

        int byIndex = line.indexOf("/by");
        String description = line.substring(DEADLINE_PREFIX_LENGTH, byIndex).trim();
        String by = line.substring(byIndex + BY_PREFIX_LENGTH).trim();

        checkEmpty(description, "deadline task content");
        checkEmpty(by, "/by label content");

        Task t = new Deadline(description, "D", by);
        tasks.add(t);
        System.out.println(OUTPUT_INDENTATION + "Got it! Deadline task added: ");
        System.out.println(SECOND_LINE_INDENTATION + t);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + Task.getNumberOfTasks() + " tasks in the list.");
    }

    private static void handleCommandTodo(String line, ArrayList<Task> tasks) throws KittenException {
        String description = line.substring(TODO_PREFIX_LENGTH).trim();

        checkEmpty(description, "todo task content");

        Task t = new Todo(description, "T");
        tasks.add(t);
        System.out.println(OUTPUT_INDENTATION + "Got it! Todo task added: ");
        System.out.println(SECOND_LINE_INDENTATION + t);
        System.out.println(OUTPUT_INDENTATION + "Now you have " + Task.getNumberOfTasks() + " tasks in the list.");
    }

    private static void handleCommandUnmark(String line, ArrayList<Task> tasks) throws KittenException {
        line = line.substring(UNMARK_PREFIX_LENGTH).trim();

        checkEmpty(line, "unmark index");

        try {
            int thisIndex = Integer.parseInt(line);

            checkIndex(thisIndex);

            Task t = tasks.get(thisIndex - 1);
            t.markAsUndone();
            System.out.println(OUTPUT_INDENTATION + "All right, I've marked this task as not done yet:");
            System.out.println(SECOND_LINE_INDENTATION + t);
        } catch (NumberFormatException e) {
            throw new KittenException(NON_NUMERICAL_INDEX_EXCEPTION_REPORT, NON_NUMERICAL_INDEX_EXCEPTION_SOLUTION);
        }
    }

    private static void handleCommandMark(String line, ArrayList<Task> tasks) throws KittenException {
        line = line.substring(MARK_PREFIX_LENGTH).trim();

        checkEmpty(line, "mark index");

        try {
            int thisIndex = Integer.parseInt(line);

            checkIndex(thisIndex);

            Task t = tasks.get(thisIndex - 1);
            t.markAsDone();
            System.out.println(OUTPUT_INDENTATION + "Good job, have a rest! I've marked this task as done:");
            System.out.println(SECOND_LINE_INDENTATION + t);
        } catch (NumberFormatException e) {
            throw new KittenException(NON_NUMERICAL_INDEX_EXCEPTION_REPORT, NON_NUMERICAL_INDEX_EXCEPTION_SOLUTION);
        }
    }

    private static void handleCommandList(ArrayList<Task> tasks) {
        System.out.println(OUTPUT_INDENTATION + "Here are the tasks in your list:");
        for (int i = 1; i <= Task.getNumberOfTasks(); i++) {
            Task t = tasks.get(i - 1);
            System.out.println(OUTPUT_INDENTATION + i + ". " + t);
        }
    }

    private static void checkLabel(String description, String s) throws LackOfLabelException {
        if (!description.contains(s)) {
            throw new LackOfLabelException(s);
        }
    }

    private static void checkEmpty(String description, String content) throws ContentIsEmptyException {
        if (description.isEmpty()) {
            throw new ContentIsEmptyException(content);
        }
    }

    private static void checkIndex(int thisIndex) throws InvalidTaskIndexException {
        if (thisIndex <= 0 || thisIndex > Task.getNumberOfTasks()) {
            throw new InvalidTaskIndexException();
        }
    }

    private static void printWelcomeMessage() {
        System.out.print(DIALOGUE_DIVIDER);
        System.out.println(OUTPUT_INDENTATION + "Hey! I'm Kitten~ Good to see you again!");
        System.out.println(OUTPUT_INDENTATION + "What can I do for you? I'm always here to be with you~");
        System.out.println(DIALOGUE_DIVIDER);
    }

    private static void printByeMessage() {
        System.out.println(OUTPUT_INDENTATION + "Bye~ Have a nice day and all the best!");
        System.out.print(DIALOGUE_DIVIDER);
    }
}
