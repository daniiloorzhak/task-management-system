package ru.oorzhak.taskmanagementsystem.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.oorzhak.taskmanagementsystem.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t " +
            "where (:executorUsername is null or t.executor.username = :executorUsername) " +
            "   and (:authorUsername is null or t.author.username = :authorUsername)")
    List<Task> findAllByParams(String executorUsername, String authorUsername, Pageable pageable);
}
