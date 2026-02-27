package parser;

import exception.ContentIsEmptyException;
import exception.KittenException;
import exception.LackOfLabelException;
import task.Deadline;
import task.Event;
import task.Todo;

public class Parser {

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


    public static String getCommandType(String fullCommand) {
        return fullCommand.trim().split(" ")[0].toLowerCase();
    }

    public static int parseIndex(String fullCommand, String prefix) throws KittenException {
        String content = fullCommand.replaceFirst(prefix, "").trim();
        if (content.isEmpty()) {
            throw new ContentIsEmptyException(prefix + " index");
        }
        try {
            return Integer.parseInt(content);
        } catch (NumberFormatException e) {
            throw new KittenException(NON_NUMERICAL_INDEX_EXCEPTION_REPORT, NON_NUMERICAL_INDEX_EXCEPTION_SOLUTION);
        }
    }

    public static Todo parseTodo(String fullCommand) throws ContentIsEmptyException {
        String description = fullCommand.substring(TODO_PREFIX_LENGTH).trim();
        if (description.isEmpty()) {
            throw new ContentIsEmptyException("todo content");
        }
        return new Todo(description, "T");
    }

    public static Deadline parseDeadline(String fullCommand) throws KittenException {
        if (!fullCommand.contains("/by")) {
            throw new LackOfLabelException("/by");
        }
        int byIndex = fullCommand.indexOf("/by");
        String description = fullCommand.substring(DEADLINE_PREFIX_LENGTH, byIndex).trim();
        String by = fullCommand.substring(byIndex + BY_PREFIX_LENGTH).trim();

        if (description.isEmpty()) throw new ContentIsEmptyException("deadline description");
        if (by.isEmpty()) throw new ContentIsEmptyException("/by content");

        return new Deadline(description,"D", by);
    }

    public static Event parseEvent(String fullCommand) throws KittenException {
        if (!fullCommand.contains("/from") || !fullCommand.contains("/to")) {
            throw new LackOfLabelException("/from and /to");
        }
        int fromIndex = fullCommand.indexOf("/from");
        int toIndex = fullCommand.indexOf("/to");

        String description = fullCommand.substring(EVENT_PREFIX_LENGTH, fromIndex).trim();
        String from = fullCommand.substring(fromIndex + FROM_PREFIX_LENGTH, toIndex).trim();
        String to = fullCommand.substring(toIndex + TO_PREFIX_LENGTH).trim();

        if (description.isEmpty() || from.isEmpty() || to.isEmpty()) {
            throw new ContentIsEmptyException("event details");
        }

        return new Event(description, "E", from, to);
    }
}
