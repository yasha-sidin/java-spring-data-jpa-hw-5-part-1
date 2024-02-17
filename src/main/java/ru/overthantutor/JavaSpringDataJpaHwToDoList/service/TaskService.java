package ru.overthantutor.JavaSpringDataJpaHwToDoList.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.domain.Task;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.domain.TaskStatus;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Task service
 */
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    /**
     * Saving task into repository
     * @param task task entity
     * @return     saved task
     */
    public Task addTask(Task task) {
        return repository.save(task);
    }

    /**
     * Get all tasks from repository
     * @return list of tasks
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Get all tasks from repository which are grouped by status
     * @param taskStatus grouping status
     * @return           filtered by status list of tasks
     */
    public List<Task> filterTasksByStatus(TaskStatus taskStatus) {
        Task task = new Task();
        task.setStatus(taskStatus);
        return repository.findAll(Example.of(task));
    }

    /**
     * Update task
     * @param task task with updated fields
     * @return     updated task
     */
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    /**
     * Deleting data
     * @param task task entity
     */
    public void deleteTask(Task task) {
        repository.delete(task);
    }

    /**
     * Find task by id
     * @param id task uuid
     * @return   optional task
     */
    public Optional<Task> getTaskById(UUID id) {
        return repository.findById(id);
    }
}
