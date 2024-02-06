package io.example.TodoApi.repositories;

import io.example.TodoApi.models.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> { }
