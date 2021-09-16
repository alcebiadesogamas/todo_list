package br.com.challenge.todoList.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.todoList.models.ToDoList;

@RestController
@RequestMapping(value = "/todo-lists")
public class ToDoListResource {

	@GetMapping
	public ResponseEntity<ToDoList> findAll() {
		ToDoList tdl = new ToDoList(1L, "Home Works", null, null, null);
		return ResponseEntity.ok().body(tdl);
	}
}
