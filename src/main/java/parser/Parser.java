package parser;

import command.AddCommand;
import command.ByeCommand;
import command.DeleteCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import command.FindCommand;
import command.Command;
import exception.ContentIsEmptyException;
import exception.InvalidCommandException;
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
    public static final String NON_NUMERICAL_INDEX_EXCEPTION_REPORT = "[NonNumericalIndex] The index cannot be interpreted into numerical values.";
    public static final String NON_NUMERICAL_INDEX_EXCEPTION_SOLUTION = "Try: Input a numerical task index";

    public static Command parse(String fullCommand) throws KittenException {
        String commandType = getCommandType(fullCommand);

        switch (commandType) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(parseIndex(fullCommand, "mark"));
        case "unmark":
            return new UnmarkCommand(parseIndex(fullCommand, "unmark"));
        case "delete":
            return new DeleteCommand(parseIndex(fullCommand, "delete"));
        case "todo":
            return new AddCommand(parseTodo(fullCommand), "Todo");
        case "deadline":
            return new AddCommand(parseDeadline(fullCommand), "Deadline");
        case "event":
            return new AddCommand(parseEvent(fullCommand), "Event");
        case "find":
            return new FindCommand(parseFind(fullCommand));
        default:
            throw new InvalidCommandException();
        }
    }

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

    public static String parseFind(String fullCommand) throws ContentIsEmptyException {
        String target = fullCommand.substring(4).trim();
        if(target.isEmpty()) {
            throw new ContentIsEmptyException("search prompt");
        }
        return target;
    }

    public static Todo parseTodo(String fullCommand) throws ContentIsEmptyException {
        String description = fullCommand.substring(TODO_PREFIX_LENGTH).trim();
        if (description.isEmpty()) {
            throw new ContentIsEmptyException("todo task content");
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

        if (description.isEmpty()) {
            throw new ContentIsEmptyException("deadline task content");
        }
        if (by.isEmpty()) {
            throw new ContentIsEmptyException("/by label content");
        }

        return new Deadline(description, "D", by);
    }

    public static Event parseEvent(String fullCommand) throws KittenException {
        if (!fullCommand.contains("/from")) {
            throw new LackOfLabelException("/from");
        }

        if (!fullCommand.contains("/to")) {
            throw new LackOfLabelException("/to");
        }

        int fromIndex = fullCommand.indexOf("/from");
        int toIndex = fullCommand.indexOf("/to");

        String description = fullCommand.substring(EVENT_PREFIX_LENGTH, fromIndex).trim();
        String from = fullCommand.substring(fromIndex + FROM_PREFIX_LENGTH, toIndex).trim();
        String to = fullCommand.substring(toIndex + TO_PREFIX_LENGTH).trim();

        if (description.isEmpty()) {
            throw new ContentIsEmptyException("event task content");
        }
        if (from.isEmpty()) {
            throw new ContentIsEmptyException("/from label content");
        }
        if (to.isEmpty()) {
            throw new ContentIsEmptyException("/to label content");
        }

        return new Event(description, "E", from, to);
    }


}
