package com.codurance.training.tasks;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class TaskListTests {

    @Test
    public void testExecuteWithAdditionOfAProjectContainingOneTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("show");

        String expected = "caizin\n[ ] 1: Task1\n"; // use \n instead of \r\n
        assertEquals(expected, writer.toString());
    }

    @Test
    public void testExecuteWithAdditionOfAProjectContainingACoupleOfTasks() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");
        taskList.execute("show");

        String expected = "caizin\n[ ] 1: Task1\n[ ] 2: Task2\n"; // use \n instead of \r\n
        assertEquals(expected, writer.toString());
    }
}