package com.imranshokat.library.service;

import java.util.List;

import com.imranshokat.library.model.Book;

import javassist.NotFoundException;

public interface BookService {

	Book addBook(Book book);
	
	Book updateBook(Book book) throws NotFoundException;
	
	void deleteBook(Long id) throws NotFoundException;
	
	Book getBook(Long id)throws NotFoundException;
	
	List<Book> getList();
}
