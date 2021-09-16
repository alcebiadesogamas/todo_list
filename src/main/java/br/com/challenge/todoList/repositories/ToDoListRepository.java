package br.com.challenge.todoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.challenge.todoList.models.ToDoList;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long>{

}
