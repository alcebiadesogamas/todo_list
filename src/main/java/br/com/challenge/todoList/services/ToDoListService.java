package br.com.challenge.todoList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.todoList.models.ToDoList;
import br.com.challenge.todoList.repositories.ToDoListRepository;

@Service
public class ToDoListService {
	
	@Autowired
	private ToDoListRepository tdlRepository;
	
	public List<ToDoList> findAll() {
		return tdlRepository.findAll();
	}
	
	public ToDoList findById(Long id) {
		Optional<ToDoList> obj = tdlRepository.findById(id);
		return obj.get();
	}
	
	public ToDoList insert(ToDoList obj) {
		return tdlRepository.save(obj);
	}
	
	public void delete(Long id) {
		tdlRepository.deleteById(id);
	}
	
	public ToDoList update(Long id, ToDoList obj) {
		ToDoList entity = tdlRepository.getById(id);
		updateData(entity, obj);
		return tdlRepository.save(entity);
	}

	private void updateData(ToDoList entity, ToDoList obj) {
		entity.setName(obj.getName());
		entity.setUpdated_at(obj.getUpdated_at());
	}
}
