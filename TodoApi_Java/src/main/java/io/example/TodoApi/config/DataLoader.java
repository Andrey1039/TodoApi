package io.example.TodoApi.config;

import io.example.TodoApi.models.TodoItem;
import io.example.TodoApi.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner
{
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception
    {
        List<TodoItem> todoList = (List<TodoItem>) todoItemRepository.findAll();

        if (todoList.isEmpty())
            todoItemRepository.save(new TodoItem("this is the first todo"));
    }
}
