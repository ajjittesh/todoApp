package com.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}

	private TodoService todoservice;

	@RequestMapping("say-heytodo")
	public String findByName(ModelMap model) {
		String username = getUsername();
		List<Todo> todos = todoservice.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = (String) model.get("name");
		todoservice.addTodo(username, todo.getDescription(), todo.getTarget(), false);
		return "redirect:say-heytodo";
	}

	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoservice.deleteById(id);
		return "redirect:say-heytodo";
	}
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showupdateTodo(@RequestParam int id,ModelMap model) {
		Todo todo=todoservice.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todoservice.updateTodo(todo);
		String username = (String) model.get("name");
		todo.setUsername(username);
		return "redirect:say-heytodo";
	}

	private String getUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}
}
