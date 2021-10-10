package br.com.challenge.todoList.dtos;

import java.io.Serializable;

import br.com.challenge.todoList.models.Task;
import br.com.challenge.todoList.models.ToDoList;

public class TaskDto implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private Long id;
	private String description;
	private Boolean status;
  private Long toDoListId;

  public TaskDto() {
  }

  public TaskDto(Task task){
    this.id = task.getId();
    this.description = task.getDescription();
    this.status = task.getStatus();
    this.toDoListId = task.getToDoList().getId();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Long getToDoListId() {
    return toDoListId;
  }

  public void setToDoListId(Long toDoListId) {
    this.toDoListId = toDoListId;
  }
  
}
