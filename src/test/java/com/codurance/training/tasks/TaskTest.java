package com.codurance.training.tasks;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskTest extends TestCase {
    public void testExtractedReturnsFalseIfTaskNotFound() {
        // Arrange: create tasks and a project
        Task task1 = new Task(1, "Task1", false);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);

        Map<String, List<Task>> projectMap = new HashMap<>();
        projectMap.put("ProjectA", tasks);
        Map.Entry<String, List<Task>> projectEntry = projectMap.entrySet().iterator().next();

        // Act: try to mark non-existing task id=5
        boolean result = Task.extracted(true, projectEntry, 5);

        // Assert
        assertFalse(result); // should return false
        assertFalse(task1.isDone()); // task1 should remain unchanged
    }
}