package org.developer.elbetasal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	private final BookRepository repository;

	public BookController(BookRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/booksmvc")
	public String getMapping(Model model){
		model.addAttribute("books" , repository.findAllBooks());
		return "books";
	}

}
