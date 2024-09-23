package com.idea.demo.tasks;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/home")
    public String homePage(){
        return "Welcome to the web-app";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createTask(@RequestBody Task task){

        taskRepository.addTask(task);
    }

    @GetMapping("")
    public List<Task> getAllTasks(){

        return taskRepository.getAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskId(@PathVariable("id") int id){

        return taskRepository.getTaskById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompleted(@RequestBody boolean completed, @PathVariable("id") Integer id){
        taskRepository.updateCompleted(completed,id);
    }

    @PutMapping("/updateDetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDetails(@RequestParam String title, @RequestParam String description, @PathVariable int id){
        taskRepository.updateDetails(title,description, id);
    }
}
