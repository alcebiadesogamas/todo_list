package br.com.challenge.todoList.controllers;

import java.net.URI;
import java.util.List;
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
		return convertToDto(tasks);
	}

	private ResponseEntity<List<TaskDto>> convertToDto(List<Task> tasks) {
		List<TaskDto> listDto = tasks.stream()
				.map(x -> new TaskDto(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		Task obj = taskService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@GetMapping(value="from/{toDoListId}")
	public ResponseEntity<List<TaskDto>> findByToDoListId(@PathVariable Long toDoListId){
		List<Task> tasks = taskService.findByToDoListId(toDoListId);
		return convertToDto(tasks);
	}
	
	@PostMapping
	public ResponseEntity<Task> insert(@RequestBody TaskDto obj) {
		ToDoList toDoList = toDoListService.findById(obj.getToDoListId());
		if(toDoList.equals(null))
			throw new ResourceNotFoundException(obj.getToDoListId());
		Task t = new Task();
		t.setToDoList(toDoList);
		t.setDescription(obj.getDescription());
		t = taskService.insert(t);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(t.getId())
				.toUri();
		return ResponseEntity.created(uri).body(t);
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
