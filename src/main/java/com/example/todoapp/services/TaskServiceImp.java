package com.example.todoapp.services;

import com.example.todoapp.model.Task;
import com.example.todoapp.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImp implements  TaskService{
    private final TaskRepo repo;

    public TaskServiceImp(TaskRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Task> getalltask() {
        return repo.findAll();
    }

    @Override
    public void createTask(Task task) {
        repo.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void toggleStatus(Long id) {
        Task task = repo.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted()); // toggle
        repo.save(task);
    }
}
