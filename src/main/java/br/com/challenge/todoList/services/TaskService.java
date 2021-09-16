package br.com.challenge.todoList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public Task findById(Long id) {
		Optional<Task> obj = taskRepository.findById(id);
		return obj.get();
	}
	
	public Task insert(Task obj) {
		return taskRepository.save(obj);
	}
}
