package com.codurance.training.tasks;

public class ShowCommand implements Command {
    private final TaskList taskList;

    public ShowCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(String arguments) throws Exception {
        taskList.show();
    }
}


