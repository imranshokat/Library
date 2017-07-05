package com.imranshokat.library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.imranshokat.library.model.Book;
import com.imranshokat.library.service.BookService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private BookService service;

	@PostMapping
	public @ResponseBody ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.addBook(book));
	}

	@PutMapping
	public @ResponseBody ResponseEntity<?> updateBook(@RequestBody Book book) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.service.updateBook(book));
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<?> deleteBook(@PathVariable String id) {
		try {
			this.service.deleteBook(new Long(id));
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (NotFoundException | NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<?> getBook(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.service.getBook(new Long(id)));
		} catch (NotFoundException | NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<Book>> getList() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.getList());
	}
}
