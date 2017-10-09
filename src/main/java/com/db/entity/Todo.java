package com.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _todoId;
    private String _todoName;
    private String _todoDesc;
    private boolean _isCompleted;

    public Todo( ) {
        super();
    }

    public Todo(String _todoName, String _todoDesc, boolean _isCompleted) {
        super();
        this._todoName = _todoName;
        this._todoDesc = _todoDesc;
        this._isCompleted = _isCompleted;
    }


    public long get_todoId( ) {
        return _todoId;
    }

    public void set_todoId(long _todoId) {
        this._todoId = _todoId;
    }

    public String get_todoName( ) {
        return _todoName;
    }

    public void set_todoName(String _todoName) {
        this._todoName = _todoName;
    }

    public String get_todoDesc( ) {
        return _todoDesc;
    }

    public void set_todoDesc(String _todoDesc) {
        this._todoDesc = _todoDesc;
    }

    public boolean is_isCompleted( ) {
        return _isCompleted;
    }

    public void set_isCompleted(boolean _isCompleted) {
        this._isCompleted = _isCompleted;
    }


    @Override
    public String toString( ) {
        return "Todo{" + "_todoId=" + _todoId + ", _todoName='" + _todoName + '\'' + ", _todoDesc='" + _todoDesc + '\'' + ", _isCompleted=" + _isCompleted + '}';
    }

}
