package br.com.challenge.todoList;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.challenge.todoList.controllers.TaskController;
import br.com.challenge.todoList.dtos.TaskDto;

@SpringBootTest
@Profile("test")
@DisplayName("Test for task controller")
public class TaskControllerTests {
  @Autowired
  private TaskController taskController;


  @Test
  @DisplayName("It should return 200 if has registered tasks")
  void findAll_FindAllTask_WhenSuccessful() {
    // Arrange
    // Act
    ResponseEntity<List<TaskDto>> response = taskController.findAll();

    // Assert
    Assertions.assertThat(response.getBody()).isNotNull();
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
