package com.idea.demo.exceptions;

public class TaskExistsAlreadyException extends RuntimeException {
    public TaskExistsAlreadyException(int id) {
        super("Task with id:" + id + " already exists in the repository");
    }
}
