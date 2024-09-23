package com.idea.demo.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class TaskControllerTest {


    private final Task task = new Task();

    private TaskController taskController;
    private TaskRepository taskRepository;

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
        assertEquals(task,taskController.getTaskId(3));



    }

    @Test
    public void getAllTasks(){
        taskController.createTask(task);
        assertEquals(1, taskController.getAllTasks().size());
    }

    @Test
    public void getTaskById(){
        taskController.createTask(task);
        assertEquals(3,taskController.getTaskId(3).getId());
    }

    @Test
    public void updateCompletedStatus() {
        taskRepository.addTask(task);
        taskController.updateCompleted(true, task.getId());
        assertEquals(true, task.getCompleted());
    }
    @Test
    public void updateDetails () {
        String updatedTitle = "Updated Title";
        String updatedDescription = "Updated Description";
        taskRepository.addTask(task);
        taskController.updateDetails(updatedTitle, updatedDescription,task.getId());
        assertEquals("Updated Title", task.getTitle());
        assertEquals("Updated Description", task.getDescription());
    }

    @Test
    public void taskDoesNotExist() {
        assertNull(taskRepository.getTaskById(1));
    }

    @Test
    public void updateTask(){
        Task updatedTask = new Task();
        updatedTask.setTitle("Set new Title");
        updatedTask.setDescription("Set new Description");
        updatedTask.setId(3);
        updatedTask.setDate(Mockito.mock());
        updatedTask.setCompleted_date(Mockito.mock());
        updatedTask.setCompleted(true);

        taskRepository.addTask(task);
        taskRepository.updateTask(updatedTask);
        assertEquals(updatedTask.getTitle(), taskRepository.getTaskById(updatedTask.getId()).getTitle());
        assertEquals(updatedTask.getDescription(), taskRepository.getTaskById(updatedTask.getId()).getDescription());
        assertEquals(updatedTask.getCompleted(), taskRepository.getTaskById(updatedTask.getId()).getCompleted());

    }

}
