package com.imranshokat.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import com.imranshokat.library.model.Book;
import com.imranshokat.library.repository.BookRepository;

import javassist.NotFoundException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;

	@Override
	public Book addBook(Book book) {
		return this.repository.saveAndFlush(new Book(book.getTitle(), book.getAuthor(), book.getDescription(),
				book.getPrice(), book.getGenre(), book.getPublishDate()));
	}

	@Override
	public Book updateBook(Book book) throws NotFoundException {
		if (this.repository.findOne(book.getId()) == null) {
			throw new NotFoundException("");
		}
		return this.repository.saveAndFlush(book);
	}

	@Override
	public void deleteBook(Long id) throws NotFoundException {
		Book book = this.repository.findOne(id);
		if (book == null) {
			throw new NotFoundException("");
		}
		this.repository.delete(book);
	}

	@Override
	public Book getBook(Long id) throws NotFoundException {
		Book book = this.repository.findOne(id);
		if (book == null) {
			throw new NotFoundException("");
		}
		return book;
	}

	@Override
	public List<Book> getList() {
		return this.repository.findAll();
	}

}
