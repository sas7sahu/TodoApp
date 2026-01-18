package com.example.todoapp.services;

import com.example.todoapp.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {
    List<Task> getalltask();
    void createTask(Task task);
    void deleteTask(Long id);
    void toggleStatus(Long id);
}
