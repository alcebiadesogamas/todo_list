package br.com.challenge.todoList.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.models.ToDoList;
import br.com.challenge.todoList.repositories.TaskRepository;
import br.com.challenge.todoList.repositories.ToDoListRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ToDoListRepository toDoListRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		ToDoList l1 = new ToDoList();
		ToDoList l2 = new ToDoList();
		
		Task t1 = new Task(
				null, 
				"shake hands",
				Instant.parse("2019-06-20T19:53:07Z"),
				null, 
				l2
				);
		Task t2 = new Task(
				null, 
				"shake feet",
				Instant.parse("2019-06-20T19:53:07Z"),
				null,
				l2
				);
		
		
		Task t3 = new Task(
				null, 
				"Math Home work",
				Instant.parse("2019-06-20T19:53:07Z"),
				null,
				l1
				);
		
		Task t4 = new Task(
				null, 
				"English Home work",
				Instant.parse("2019-06-20T19:53:07Z"),
				null,
				l1
				);
		
		l1.setName("Home Works");
		l1.setCreated_at(Instant.parse("2019-06-20T19:53:07Z"));
		l1.setTasks(Arrays.asList(t3,t4));
		l2.setName("Workout");
		l2.setCreated_at(Instant.parse("2019-06-20T19:53:07Z"));
		l2.setTasks(Arrays.asList(t1,t2));
		
		
		toDoListRepository.saveAll(Arrays.asList(l1,l2));
		taskRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
	}
	
}
