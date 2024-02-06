package io.example.TodoApi.controllers;

import io.example.TodoApi.models.TodoItem;
import io.example.TodoApi.repositories.TodoItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todoitems")
@CrossOrigin
public class TodoItemController
{
    private final TodoItemRepository todoItemRepository;

    public TodoItemController(TodoItemRepository todoItemRepository)
    {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping("")
    public List<TodoItem> findAllTodoItems()
    {
        return (List<TodoItem>) todoItemRepository.findAll();
    }

    @PostMapping("")
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem)
    {
        TodoItem newItem = new TodoItem();
        
        newItem.setDescription(todoItem.getDescription());
        newItem.setComplete(todoItem.isComplete());
        newItem = todoItemRepository.save(newItem);

        return newItem;
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> getTodoItem(@PathVariable("id") long id)
    {
        return todoItemRepository.findById(id);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable("id") long id, @RequestBody TodoItem todoItem)
    {
        Optional<TodoItem> item = todoItemRepository.findById(id);
        TodoItem updatedItem = new TodoItem();

        if (item.isPresent())
        {
            updatedItem = item.get();
            updatedItem.setDescription(todoItem.getDescription());
            updatedItem.setComplete(todoItem.isComplete());
            updatedItem = todoItemRepository.save(updatedItem);
        }

        return updatedItem;
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable("id") long id)
    {
        Optional<TodoItem> item = todoItemRepository.findById(id);

        if (item.isPresent())
            todoItemRepository.delete(item.get());
    }
}