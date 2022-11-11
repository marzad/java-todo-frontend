package de.neuefische.marzad.backend.controller;

import de.neuefische.marzad.backend.repository.ToDoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TasksControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ToDoRepo toDoRepo;

    @Test
    void getToDoList() throws Exception {

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
[]
"""));
    }

    @Test
    void addTask() throws Exception {
        mockMvc.perform(post("/api/todo").content("abc"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
{
"description" : "abc",
"status" : "OPEN"
}
"""));
    }

    @Test
    void getTaskDetails() throws Exception {
        toDoRepo.addTask("abc");
        mockMvc.perform(get("/api/todo/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("TaskModel[id=1, description=abc, status=OPEN]"));
    }
}