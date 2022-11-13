package de.neuefische.marzad.backend.service;

import de.neuefische.marzad.backend.model.Status;
import de.neuefische.marzad.backend.model.TaskModel;
import de.neuefische.marzad.backend.model.TaskToDo;
import de.neuefische.marzad.backend.repository.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

/*    public List<TaskToDo> getToDoList() {
        List<TaskToDo> newList = new ArrayList<>();
        for(TaskModel t: toDoRepo.getToDoList()){
            TaskToDo newTask = new TaskToDo(t.id(), t.description());
            newList.add(newTask);
        }
        return newList;
    }*/

    public TaskModel getTaskDetails(int id) {
        return toDoRepo.getTaskDetails(id);
    }

    public TaskModel changeStatusOfTask(int id, Status status) {
        return toDoRepo.changeStatusOfTask(id, status);
    }

    public TaskModel deleteTask(int id) {
        return toDoRepo.deleteTask(id);
    }
}
