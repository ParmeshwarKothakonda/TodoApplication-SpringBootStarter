package com.example.todo;

import com.example.todo.Todo;
import java.util.*;

public interface TodoRepository{

    ArrayList<Todo> getTodos();

    Todo getTodoById(int id);

    Todo addTodo(Todo todo);

    Todo updateTodo(int id, Todo todo);

    void deleteTodo(int id);
}
