package br.com.challenge.todoList.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.challenge.todoList.dtos.TaskDto;
import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.models.ToDoList;
import br.com.challenge.todoList.services.TaskService;
import br.com.challenge.todoList.services.ToDoListService;
import br.com.challenge.todoList.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private ToDoListService toDoListService;
	
	@GetMapping
	public ResponseEntity<List<TaskDto>> findAll() {
		List<Task> tasks = taskService.findAll();
		List<TaskDto> listDto = tasks.stream().map(x -> new TaskDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		Task obj = taskService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/{toDoListId}")
	public ResponseEntity<Task> insert(@PathVariable Long toDoListId, @RequestBody Task obj) {
		ToDoList toDoList = toDoListService.findById(toDoListId);
		if(toDoList.equals(null))
			throw new ResourceNotFoundException(toDoListId);
		obj.setToDoList(toDoList);	
		obj = taskService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		taskService.delete(id);
		String msg = "Tarefa removida com sucesso";
		return ResponseEntity.ok().body(msg);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task obj) {
		Task aux = taskService.findById(id);
		if (aux.equals(null))
			throw new ResourceNotFoundException(id);
		Long toDoListId = aux.getToDoList().getId();
		ToDoList toDoList = toDoListService.findById(toDoListId);
		obj.setToDoList(toDoList);
		obj = taskService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
