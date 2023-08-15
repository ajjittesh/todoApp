package com.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

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

	public void deleteById(int id) {
	
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}

	

}
