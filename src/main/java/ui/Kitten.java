package ui;

import command.Command;
import exception.KittenException;
import parser.Parser;
import storage.Storage;
import task.TaskList;

import java.io.IOException;

/**
 * The main class for the Kitten task management application.
 * It initializes the core components—UI, Storage, and TaskList—and
 * runs the main program loop to process user commands.
 */
public class Kitten {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Initializes the Kitten application with a specified file path for data storage.
     * Attempts to load existing tasks from the file; if unsuccessful, starts with an empty list.
     *
     * @param filePath The path to the file where task data is stored.
     */
    public Kitten(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showError("[IOException] No existing list found. Start with a new one~");
            tasks = new TaskList();
        }
    }

    private void run() {
        ui.printWelcomeMessage();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (KittenException e) {
                ui.showError(e.getMessage());
                ui.showSuggestion(e.getSuggestion());
            } catch (IOException e) {
                ui.showError("[IOException] Error saving to file!");
            } finally {
                ui.separateLine();
            }
        }
    }

    /**
     * Entry point of the application.
     * Creates a new Kitten instance with a default data file path and runs it.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new Kitten("./data/KittenList.txt").run();
    }
}