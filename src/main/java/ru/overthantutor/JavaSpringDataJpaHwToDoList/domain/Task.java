package ru.overthantutor.JavaSpringDataJpaHwToDoList.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Task entity
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    /**
     * Task id
     */
    @Id
    @GeneratedValue
    private UUID id;
    /**
     * Task label
     */
    @Column(name = "label")
    private String label;
    /**
     * Task body
     */
    @Column(name = "body")
    private String body;
    /**
     * Task status
     */
    @Column(name = "status")
    private TaskStatus status;
    /**
     * Time of creation
     */
    @Column(name = "date_of_creation")
    private LocalDateTime dateOfCreation;

    /**
     * Task constructor which will be used for the first init task
     * @param label task label
     * @param body  task body
     */
    public Task(String label, String body) {
        this.label = label;
        this.body = body;
        this.status = TaskStatus.NOT_STARTED;
        this.dateOfCreation = LocalDateTime.now();
    }
}
