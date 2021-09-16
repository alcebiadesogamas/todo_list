package br.com.challenge.todoList.resources;

import java.net.URI;
import java.util.List;

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

	@GetMapping(value = "/{id}")
	public ResponseEntity<ToDoList> findById(@PathVariable Long id) {
		ToDoList obj = tdlService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<ToDoList> insert(@RequestBody ToDoList obj) {
		obj = tdlService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tdlService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ToDoList> update(@PathVariable Long id, @RequestBody ToDoList obj) {
		obj = tdlService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
