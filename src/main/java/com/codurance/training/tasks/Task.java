package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public static boolean extracted(boolean done, Map.Entry<String, List<Task>> project, int id) {
        for (Task task : project.getValue()) {
            if (task.getId() == id) {
                task.setDone(done);
                return true;
            }
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}