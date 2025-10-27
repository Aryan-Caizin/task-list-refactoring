package com.codurance.training.tasks;

public interface Command {
    void execute(String arguments) throws Exception;
}
