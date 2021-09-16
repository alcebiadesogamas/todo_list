package br.com.challenge.todoList.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.todoList.models.ToDoList;
import br.com.challenge.todoList.services.ToDoListService;

@RestController
@RequestMapping(value = "/todo-lists")
public class ToDoListResource {

	@Autowired
	private ToDoListService tdlService;
	
	@GetMapping
	public ResponseEntity<List<ToDoList>> findAll() {
		List<ToDoList> tdls = tdlService.findAll();
		return ResponseEntity.ok().body(tdls);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ToDoList> findById(@PathVariable Long id) {
		ToDoList obj = tdlService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
