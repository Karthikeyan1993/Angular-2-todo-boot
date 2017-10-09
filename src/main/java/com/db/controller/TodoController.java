package com.db.controller;

import com.db.entity.Todo;
import com.db.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3000)
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public ResponseEntity <?> GetEntity( ) {
        return new ResponseEntity <Object>(this.todoService.GetTodoList(), HttpStatus.OK);
    }

    @GetMapping("todos/{id}")
    public ResponseEntity <?> FindEntity(@PathVariable("id") Long id) {
        return new ResponseEntity <Object>(this.todoService.FindTodo(id), HttpStatus.OK);
    }

    @PostMapping("todo")
    public ResponseEntity <?> SaveEntity(@RequestBody Todo todo) {
        return new ResponseEntity <Object>(this.todoService.SaveTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("todo/{id}")
    public ResponseEntity <?> DeleteEntity(@PathVariable("id") Long id) {
        return new ResponseEntity <Object>(this.todoService.DeleteTodo(id), HttpStatus.OK);
    }

    @PostMapping("todo/{id}")
    public ResponseEntity <?> UpdateEntity(@RequestBody Todo todo, @PathVariable("id") Long id) {
        return new ResponseEntity <Object>(this.todoService.UpdateTodo(todo, id), HttpStatus.OK);
    }

}
