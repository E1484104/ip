package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.KittenException;
import java.io.IOException;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws KittenException, IOException;

    public boolean isExit() {
        return false;
    }
}
