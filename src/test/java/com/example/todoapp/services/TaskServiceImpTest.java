package com.example.todoapp.services;

import com.example.todoapp.model.Task;
import com.example.todoapp.repo.TaskRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImpTest {

    @Mock
    private TaskRepo repo;

    @InjectMocks
    private TaskServiceImp service;


    @Test
    void shouldReturnAllTasks() {
        Task task1 = new Task();
        task1.setTitle("Task 1");

        Task task2 = new Task();
        task2.setTitle("Task 2");

        when(repo.findAll()).thenReturn(List.of(task1, task2));

        List<Task> tasks = service.getalltask();

        assertEquals(2, tasks.size());
        verify(repo, times(1)).findAll();
    }

    // ------------------- createTask -------------------

    @Test
    void shouldSaveTask() {
        Task task = new Task();
        task.setTitle("New Task");

        service.createTask(task);

        verify(repo, times(1)).save(task);
    }

    // ------------------- deleteTask -------------------

    @Test
    void shouldDeleteTaskById() {
        Long id = 1L;

        service.deleteTask(id);

        verify(repo, times(1)).deleteById(id);
    }

    // ------------------- toggleStatus -------------------

    @Test
    void shouldToggleTaskStatus() {
        Task task = new Task();
        task.setCompleted(false);

        when(repo.findById(1L)).thenReturn(Optional.of(task));

        service.toggleStatus(1L);

        assertTrue(task.isCompleted());
        verify(repo, times(1)).save(task);
    }

    @Test
    void shouldThrowExceptionIfTaskNotFound() {
        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.toggleStatus(99L));
    }
}
