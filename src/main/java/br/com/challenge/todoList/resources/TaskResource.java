package br.com.challenge.todoList.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.services.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskResource {

	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> tasks = taskService.findAll();
		return ResponseEntity.ok().body(tasks);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		Task obj = taskService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
