package br.com.challenge.todoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.todoList.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
