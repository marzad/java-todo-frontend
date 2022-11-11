package de.neuefische.marzad.backend.controller;


import de.neuefische.marzad.backend.model.TaskModel;
import de.neuefische.marzad.backend.repository.ToDoRepo;
import de.neuefische.marzad.backend.service.TaskService;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TasksController {
    private TaskService taskService;
    private ToDoRepo toDoRepo = new ToDoRepo();

    public TasksController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("todo")
    public List<TaskModel> getToDoList(){
        return taskService.getToDoList();
    }

    @PostMapping("todo")
    public TaskModel addTask(@RequestBody String task){
        return taskService.addTask(task);
    }

    @GetMapping("todo/{id}")
    public String getTaskDetails(@PathVariable int id){
        return taskService.getTaskDetails(id);
    }

}
