package com.codurance.training.tasks;

import static java.lang.System.out;
import java.util.Map;

public class CheckCommand implements Command {
    private final TaskList taskList;
    private final boolean done;

    public CheckCommand(TaskList taskList, boolean done) {
        this.taskList = taskList;
        this.done = done;
    }

    @Override
    public void execute(String idString) {
        int id = Integer.parseInt(idString);
        Project projects = taskList.getProjects();

        for (Map.Entry<String, Tasks> project : projects.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }

        out.printf("Could not find a task with an ID of %d.%n", id);
    }
}
