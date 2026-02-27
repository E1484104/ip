package ui;

import command.Command;
import exception.KittenException;
import parser.Parser;
import storage.Storage;
import task.TaskList;

import java.io.IOException;

public class Kitten {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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

    public void run() {
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

    public static void main(String[] args) {
        new Kitten("./data/KittenList.txt").run();
    }
}