package com.henriqueacf.todlist.task;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        System.out.println("Bateu no Controller " + request.getAttribute("idUser"));
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
