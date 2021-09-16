package br.com.challenge.todoList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.todoList.models.ToDoList;
import br.com.challenge.todoList.repositories.ToDoListRepository;
import br.com.challenge.todoList.services.exceptions.ResourceNotFoundException;

@Service
public class ToDoListService {
	
	@Autowired
	private ToDoListRepository tdlRepository;
	
	public List<ToDoList> findAll() {
		return tdlRepository.findAll();
	}
	
	public ToDoList findById(Long id) {
		Optional<ToDoList> obj = tdlRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public ToDoList insert(ToDoList obj) {
		return tdlRepository.save(obj);
	}
}
