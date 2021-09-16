package br.com.challenge.todoList.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.repositories.TaskRepository;
import br.com.challenge.todoList.services.exceptions.ResourceNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public Task findById(Long id) {
		Optional<Task> obj = taskRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Task insert(Task obj) {
		return taskRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			taskRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}		
	}
	
	public Task update(Long id, Task obj) {
		try {
			Task entity = taskRepository.getById(id);
			updateData(entity, obj);
			return taskRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Task entity, Task obj) {
		entity.setStatus(obj.getStatus());
	}
}
