package io.example.TodoApi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
public class TodoItem implements Serializable
{
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private boolean complete;

    public TodoItem() {};

    public TodoItem(String description)
    {
        this.description = description;
        this.complete = false;
    }

    @Override
    public String toString()
    {
        return String.format("TodoItem{id=%d, description='%s', complete='%s'}",
                id, description, complete);
    }
}
