package br.com.challenge.todoList.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.challenge.todoList.models.ToDoList;
import br.com.challenge.todoList.repositories.ToDoListRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ToDoListRepository toDoListRepository;

	@Override
	public void run(String... args) throws Exception {
		ToDoList l1 = new ToDoList(
				null,
				"Home Works",
				Instant.parse("2019-06-20T19:53:07Z"),
				null,
				null
				);
		ToDoList l2 = new ToDoList(
				null,
				"WorkOut",
				Instant.parse("2019-06-20T19:53:07Z"),
				null,
				null
				);
		toDoListRepository.saveAll(Arrays.asList(l1,l2));
	}
	
}
