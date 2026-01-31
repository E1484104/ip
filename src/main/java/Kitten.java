import java.util.Scanner;

public class Kitten {

    public static final String DIALOGUE_DIVIDER = "    ____________________________________________________________\n";
    public static final String OUTPUT_INDENTATION = "     ";
    public static final String SECOND_LINE_INDENTATION = "        ";

    public static void main(String[] args) {
        printWelcomeMessage();
        handleCommand();
        printByeMessage();
    }

    private static void handleCommand() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Task[] tasks = new Task[100];

        while (!line.equals("bye")) {
            if (line.equals("list")) {
                handleCommandList(tasks);
            } else if (line.startsWith("mark")) {
                handleCommandMark(line, tasks);
            } else if (line.startsWith("unmark")) {
                handleCommandUnmark(line, tasks);
            } else {
                handleCommandAdd(line, tasks);
            }
            System.out.println(DIALOGUE_DIVIDER);

            line = in.nextLine();
        }
    }


    private static void handleCommandAdd(String line, Task[] tasks) {
        Task t = new Task(line);
        tasks[Task.getNumberOfTasks() - 1] = t;
        System.out.println(OUTPUT_INDENTATION + "Task added: " + line);
    }

    private static void handleCommandUnmark(String line, Task[] tasks) {
        String[] words = line.split(" ");
        int thisIndex = Integer.parseInt(words[1]);
        Task t = tasks[thisIndex - 1];
        t.markAsUndone();
        System.out.println(OUTPUT_INDENTATION + "All right, I've marked this task as not done yet:");
        System.out.println(SECOND_LINE_INDENTATION + "[" + t.getStatusIcon() + "] " + t.getDescription());
    }

    private static void handleCommandMark(String line, Task[] tasks) {
        String[] words = line.split(" ");
        int thisIndex = Integer.parseInt(words[1]);
        Task t = tasks[thisIndex - 1];
        t.markAsDone();
        System.out.println(OUTPUT_INDENTATION + "Good job, have a rest! I've marked this task as done:");
        System.out.println(SECOND_LINE_INDENTATION + "[" + t.getStatusIcon() + "] " + t.getDescription());
    }

    private static void handleCommandList(Task[] tasks) {
        for (int i = 1; i <= Task.getNumberOfTasks(); i++) {
            Task t = tasks[i - 1];
            System.out.println(OUTPUT_INDENTATION + i + ". [" + t.getStatusIcon() + "] " + t.getDescription());
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
