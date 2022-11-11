package de.neuefische.marzad.backend.service;

import de.neuefische.marzad.backend.model.TaskModel;
import de.neuefische.marzad.backend.repository.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private static ToDoRepo toDoRepo = new ToDoRepo();

    public TaskService(){}

    public TaskService(ToDoRepo toDoList){
        this.toDoRepo = toDoList;
    }

    public static TaskModel addTask(String task){
        return toDoRepo.addTask(task);
    }


    public List<TaskModel> getToDoList() {
        return toDoRepo.getToDoList();
    }
}
