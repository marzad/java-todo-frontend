package de.neuefische.marzad.backend.repository;

import de.neuefische.marzad.backend.model.Status;
import de.neuefische.marzad.backend.model.TaskModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepo {
    private List<TaskModel> toDoList = new ArrayList<>();

    public ToDoRepo(){}

    public  TaskModel addTask(String task){
        TaskModel newTask = new TaskModel(task, Status.OPEN);
        toDoList.add(newTask);
        return newTask;
    }

    public List<TaskModel> getToDoList(){
        return toDoList;
    }






}
