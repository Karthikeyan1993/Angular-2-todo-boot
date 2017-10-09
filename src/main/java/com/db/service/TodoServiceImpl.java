package com.db.service;

import com.db.entity.Todo;
import com.db.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(@Qualifier("todoRepository") TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List <Todo> GetTodoList( ) {
        return this.todoRepository.findAll();
    }

    @Override
    public Todo SaveTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public Todo FindTodo(Long id) {
        return this.todoRepository.findOne(id);
    }

    @Override
    public Todo DeleteTodo(Long id) {
        this.todoRepository.delete(id);
        return null;
    }

    @Override
    public Todo UpdateTodo(Todo todo, Long id) {
        todo.set_todoId(id);
        return this.todoRepository.saveAndFlush(todo);
    }
}
