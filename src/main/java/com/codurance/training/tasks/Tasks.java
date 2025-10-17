package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tasks extends ArrayList<Task> {
    void format(List<Task> tasks, Writer writer) throws IOException {
        for (Task task : this) {
            writer.write(String.format("[%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()));
        }
    }

    void extracted(Writer writer, Set<Map.Entry<String, List<Task>>> tasks) throws IOException {
        for (Map.Entry<String, List<Task>> project : tasks) {
            writer.write(project.getKey());
            writer.write("\n");
            format(project.getValue(), writer);
        }
    }
}
