package com.example.todo;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();

    int updatedId = 6;
    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    
    @Override
    public ArrayList<Todo> getTodos(){ //GET ALL Method
        Collection<Todo> todoCollection = todoList.values();
        ArrayList<Todo> todos = new ArrayList<>(todoCollection);

        return todos;
    }

    @Override
    public Todo getTodoById(int id){ //GET METHOD

        Todo todo = todoList.get(id);

        if(todo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return todo;

    }

    @Override
    public Todo addTodo(Todo todo){ //POST METHOD
        todo.setId(updatedId); //setting the Id first in hmap and giving the value to key next

        todoList.put(updatedId, todo);
        Todo savedTodo = todoList.get(updatedId);
        updatedId += 1;

        return savedTodo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo){ //UPDATE METHOD

        Todo existingTodo = todoList.get(id);

        if(existingTodo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(todo.getTodo() != null){
            existingTodo.setTodo(todo.getTodo());
        }

        if(todo.getStatus() != null){
            existingTodo.setStatus(todo.getStatus());
        }

        if(todo.getPriority() != null){
            existingTodo.setPriority(todo.getPriority());
        }


        return existingTodo;
    }

    @Override
    public void deleteTodo(int id){ //DELETE METHOD
        Todo todo = todoList.get(id);

        if(todo != null){
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
            
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            
        }
        
    }

}
