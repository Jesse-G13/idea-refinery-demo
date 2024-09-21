package com.idea.demo.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TaskControllerTest {


    private final Task task = new Task();

    TaskController taskController;
    TaskRepository taskRepository;

    @BeforeEach
    public void initTask(){
        task.setTitle("Sample API");
        task.setDescription("Sample API");
        task.setCompleted(false);
        task.setDate(Mockito.mock());
        task.setCompleted_date(Mockito.mock());
        task.setId(3);
        taskRepository = new TaskRepository();
        taskController = new TaskController(taskRepository);

    }

    @Test
    public void createTask(){

        taskController.createTask(task);
        assertEquals(1, taskController.getAllTasks().size());

    }


}
