package ru.overthantutor.JavaSpringDataJpaHwToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.overthantutor.JavaSpringDataJpaHwToDoList.domain.Task;


import java.util.UUID;

/**
 * Spring Jpa Task Repository
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
