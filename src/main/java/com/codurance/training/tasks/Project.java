package com.codurance.training.tasks;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project extends HashMap<String,Tasks> {


    Map<String,List<Task>> tasks;

    public Project() {
        this.tasks=tasks;
    }

    void format( Writer writer) throws IOException {
        for (Entry<String, Tasks> project : this.entrySet()) {
            writer.write(project.getKey());
            writer.write("\n");
            Tasks task = new Tasks();
            task.addAll(project.getValue());
            task.formated(writer);
        }
    }

    public void addProjectName(String name){
        this.put(name, new Tasks());
    }



}
