package storage;

import task.Task;
import task.Todo;
import task.Deadline;
import task.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(ArrayList<Task> tasks) throws IOException {
        File f = new File(filePath);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        FileWriter fw = new FileWriter(f);
        for (Task t : tasks) {
            fw.write(t.toFileFormat() + System.lineSeparator());
        }
        fw.close();
    }

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath);
        if (!f.exists()) {
            return tasks;
        }

        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] parts = line.split(" \\| ");
            Task t = null;
            switch (parts[0]) {
            case "T":
                t = new Todo(parts[2], "T");
                break;
            case "D":
                t = new Deadline(parts[2], "D", parts[3]);
                break;
            case "E":
                t = new Event(parts[2], "E", parts[3], parts[4]);
                break;
            }
            if (t != null) {
                if (parts[1].equals("1")){
                    t.markAsDone();
                }
                tasks.add(t);
            }
        }
        return tasks;
    }
}
