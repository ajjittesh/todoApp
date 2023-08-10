package com.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
		List<Todo> todos=todoservice.findByUsername("Ajjietesh");
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String newtodo() {

		return "todo";
	}
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model) {
		//String username = (String)model.get("name");
		todoservice.addTodo("Ajjietesh", description, 
				LocalDate.now().plusMonths(5), false);
		return "redirect:say-heytodo";
	}
	
}
