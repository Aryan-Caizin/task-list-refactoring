//package com.codurance.training.tasks;
//
//import java.util.ArrayList;
//
//public class AddCommand {
//    private final Project projects ;
//        AddCommand(TaskList taskList) { this.projects = projects; }
//
//        @Override
//        public void execute(String arguments) throws Exception {
//            String[] subParts = arguments.split(" ", 2);
//            String type = subParts[0];
//
//            String[] projectTask = null;
//            if (type.equals("project")) {
//                projects.put(subParts[1], new Tasks());
//            } else if (type.equals("task")) {
//                projectTask = subParts[1].split(" ", 2);
//                projects.addProjectName(projectTask[0], projectTask[1]);
//            }
//        }
//    }
//

package com.codurance.training.tasks;

public class AddCommand implements Command {
    private final TaskList taskList;

    public AddCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(String arguments) {
        String[] subParts = arguments.split(" ", 2);
        String type = subParts[0];

        if (type.equals("project")) {
            taskList.addProject(subParts[1]);
        } else if (type.equals("task")) {
            String[] projectTask = subParts[1].split(" ", 2);
            taskList.addTask(projectTask[0], projectTask[1]);
        }
    }
}


