package br.com.challenge.todoList.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public void delete(Long id) {
		try{
			this.tdlRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}		
	}

	public ToDoList update(Long id, ToDoList obj) {
		try {
			ToDoList entity = this.tdlRepository.getById(id);
			this.updateData(entity, obj);
			return this.tdlRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(ToDoList entity, ToDoList obj) {
		entity.setName(obj.getName());
	}
}
