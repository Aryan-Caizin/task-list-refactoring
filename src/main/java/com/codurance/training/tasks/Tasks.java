package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tasks extends ArrayList<Task> {

    void formated(Writer writer) throws IOException {
        for (Task task : this) {
            writer.write(String.format("[%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()));
        }
    }
}
