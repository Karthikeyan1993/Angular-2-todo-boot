package com.db.repository;

import com.db.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("todoRepository")
public interface TodoRepository extends JpaRepository <Todo, Long> {
}
