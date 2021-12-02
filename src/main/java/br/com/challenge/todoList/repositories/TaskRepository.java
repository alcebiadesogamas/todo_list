package br.com.challenge.todoList.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.challenge.todoList.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	@Query("SELECT t FROM Task t WHERE todo_list_id = :toDoListId")
	public List<Task> findByToDoListId(@Param("toDoListId") Long toDoListId);
}
