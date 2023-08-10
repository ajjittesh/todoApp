package com.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class TodoService {
	private static int count=0;
	private static List<Todo> todos= new ArrayList<>();
	static {
		todos.add(new Todo(++count, "Ajjietesh", "task 1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count, "Ajjietesh", "task 2", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++count, "Ajjietesh", "task 3", LocalDate.now().plusYears(3), false));
	}
	public List<Todo>findByUsername(String username){
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(++count,username,description,targetDate,done));
		
	}

}
