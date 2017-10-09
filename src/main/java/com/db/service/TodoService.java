package com.db.service;

import com.db.entity.Todo;

import java.util.List;


public interface TodoService {
    List <Todo> GetTodoList( );

    Todo SaveTodo(Todo todo);

    Todo FindTodo(Long id);

    Todo DeleteTodo(Long id);

    Todo UpdateTodo(Todo todo, Long id);
}
