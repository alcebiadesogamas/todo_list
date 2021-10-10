package br.com.challenge.todoList;

import java.net.http.HttpResponse;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import br.com.challenge.todoList.controllers.TaskController;
import br.com.challenge.todoList.controllers.ToDoListController;
import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.models.ToDoList;

@SpringBootTest
@DisplayName("Test for task controller")
public class TaskControllerTests {
  @Autowired
  private TaskController taskController;

  @Autowired
  private ToDoList toDoList;

  @Autowired
  private ToDoListController toDoListController;

  @Test
  @DisplayName("It should return 200 if has registered tasks")
  void findAll_FindAllTask_WhenSuccessful() {
    // Arrange
    // Act
    ResponseEntity<List<Task>> response = taskController.findAll();

    // Assert
    Assertions.assertThat(response.getBody()).isNotNull();
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  // @Test
  // @DisplayName("It should return 201 when try to create a task")
  // void insert_InsertTask_WhenSuccessful() {
  //   // Arrange
  //   toDoList.setName("lista teste");
  //   toDoListController.insert(toDoList);
  //   Task task = new Task();
  //   task.setDescription("Teste");
  //   task.setStatus(false);
  //   task.setToDoList(toDoList);

  //   // Act
  //   ResponseEntity<Task> response = taskController.insert(task);

  //   // Assert
  //   Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

  // }
}
