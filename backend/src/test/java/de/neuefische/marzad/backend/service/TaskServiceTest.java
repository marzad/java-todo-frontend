package de.neuefische.marzad.backend.service;

import de.neuefische.marzad.backend.model.Status;
import de.neuefische.marzad.backend.model.TaskModel;
import de.neuefische.marzad.backend.repository.ToDoRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    ToDoRepo toDoRepo = mock(ToDoRepo.class);
    TaskService taskService = new TaskService(toDoRepo);

    @Test
    void test_addTask() {
        String taskName = "Aufgabe1";
        TaskModel newTask = new TaskModel(1, taskName, Status.OPEN);

        when(toDoRepo.addTask(taskName)).thenReturn(newTask);

        TaskModel result = taskService.addTask(taskName);

        verify(toDoRepo).addTask(taskName);
        assertEquals(result, newTask);
    }

    @Test
    void test_getToDoList_whenListIsEmpty(){

        List<TaskModel> expected = new ArrayList<>();
        when(taskService.getToDoList()).thenReturn(expected);

        List<TaskModel> result = taskService.getToDoList();

        assertEquals(expected, result);

    }

    @Test
    void test_getTaskDetails(){

        TaskModel newTask = new TaskModel(1, "abc",Status.OPEN);
        toDoRepo.addTask("abc");

        when(taskService.getTaskDetails(1)).thenReturn(newTask);

        TaskModel result = taskService.getTaskDetails(1);

        assertEquals(result, newTask.toString());
    }
}