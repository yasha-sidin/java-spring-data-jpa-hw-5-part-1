package ru.overthantutor.JavaSpringDataJpaHwToDoList.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.domain.Task;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.domain.TaskStatus;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring task main rest controller
 */
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    /**
     * Send all tasks
     * @return all tasks
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Add task
     * @param task task entity
     * @return     added task
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        Task resultTask = new Task(task.getLabel(), task.getBody());
        return taskService.addTask(resultTask);
    }

    /**
     * Send statuses
     * @return statuses
     */
    @GetMapping("/statuses")
    public List<TaskStatus> getStatuses() {
        return List.of(TaskStatus.values());
    }

    /**
     * Send task which are filtered by status
     * @param taskStatus status of task
     * @return           filtered by status tasks
     */
    @GetMapping("status/{status}")
    public List<Task> getTasksByStatus(@PathVariable("status") TaskStatus taskStatus) {
        return taskService.filterTasksByStatus(taskStatus);
    }

    /**
     * Updating status of task
     * @param id   task id
     * @param task task with updated status
     * @return     updated task or null if it is not exists
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable("id") UUID id, @RequestBody Task task) {
        Optional<Task> optional = taskService.getTaskById(id);
        if (optional.isPresent()) {
            optional.get().setStatus(task.getStatus());
            return taskService.updateTask(optional.get());
        }
        return null;
    }

    /**
     * Deleting task
     * @param id task id
     * @return   deleted task or null if it is not exists
     */
    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable("id") UUID id) {
        Optional<Task> optional = taskService.getTaskById(id);
        if (optional.isPresent()) {
            taskService.deleteTask(optional.get());
            return optional.get();
        }
        return null;
    }



}
