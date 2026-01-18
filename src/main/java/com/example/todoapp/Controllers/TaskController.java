package com.example.todoapp.Controllers;

import com.example.todoapp.model.Task;
import com.example.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskService srvc;

    public TaskController(TaskService srvc) {
        this.srvc = srvc;
    }

    @GetMapping
    public  String GetTask(Model m){
        m.addAttribute("task",new Task());
        m.addAttribute("tasks", srvc.getalltask());
        return "Task";
    }
    @PostMapping("/createtask")
    public  String CreateTask(@ModelAttribute Task task){
        srvc.createTask(task);
        return "redirect:/";
    }
    @PostMapping("/tasks/delete/{id}")
    public  String DeleteTask(@PathVariable Long id){
        srvc.deleteTask(id);
        return "redirect:/";
    }
    @PostMapping("/tasks/toggle/{id}")
    public String toggleTaskStatus(@PathVariable Long id) {
        srvc.toggleStatus(id);
        return "redirect:/";
    }

}
