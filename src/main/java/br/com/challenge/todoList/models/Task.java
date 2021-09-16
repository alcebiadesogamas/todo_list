package br.com.challenge.todoList.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private Instant created_at;
	private Instant updated_at;

	public Task() {
		super();
	}

	public Task(Long id, String description, Instant created_at, Instant updated_at) {
		super();
		this.id = id;
		this.description = description;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public Instant getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}

	public Instant getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

}
