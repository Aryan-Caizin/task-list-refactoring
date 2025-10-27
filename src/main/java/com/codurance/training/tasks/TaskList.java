package com.codurance.training.tasks;

import javax.swing.*;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public final class TaskList {

    private final Project projects = new Project();
    private final Writer writer;
    private long lastId = 0;


    private final Map<String, Command> commands = new HashMap<>();

    public TaskList(Writer writer) {
        this.writer = writer;
        commands.put("show", new ShowCommand(this));
        commands.put("add", new AddCommand(this));
        commands.put("check", new CheckCommand(this, true));
        commands.put("uncheck", new CheckCommand(this, false));
    }

    public void execute(String commandLine) throws Exception {
        String[] parts = commandLine.split(" ", 2);
        String commandName = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";

        Command cmd = commands.get(commandName);
        if (cmd == null) {
            throw new IllegalArgumentException("Unknown command: " + commandName);
        }
        cmd.execute(arguments);
    }

    void show() throws IOException {
       // Project project = new Project(tasks);
        projects.format( writer);
    }


    void addProject(String name) {
        projects.addProjectName(name);
    }

    void addTask(String project, String description) {
        List<com.codurance.training.tasks.Task> projectTasks = projects.get(project);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + project);
        }
        projectTasks.add(new com.codurance.training.tasks.Task(nextId(), description, false));
    }


    private long nextId() {
        return ++lastId;
    }

    public Project getProjects() {
        return projects;
    }
}