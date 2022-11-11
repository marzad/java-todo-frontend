package de.neuefische.marzad.backend.repository;

import de.neuefische.marzad.backend.model.Status;
import de.neuefische.marzad.backend.model.TaskModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepo {
    private List<TaskModel> toDoList = new ArrayList<>();
    private int id = 0;

    public ToDoRepo(){}

    public  TaskModel addTask(String task){
        id++;
        TaskModel newTask = new TaskModel(id, task, Status.OPEN);
        toDoList.add(newTask);
        return newTask;
    }

/*    public  TaskModel addTask(TaskModel task){
    toDoList.add(task);
    return task;*/


    public List<TaskModel> getToDoList(){
        return toDoList;
    }

    public TaskModel getTaskDetails(int id) {
        for(TaskModel t: toDoList){
            if(t.id() == id){
                return t;
            }
        }
        return null;
    }
}
