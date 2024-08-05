package com.library.service;


import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;


public class BookService {
    private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    
	public void displayBooks() {
        System.out.println("Displaying books.");
        bookRepository.fetchBooks();
    }
    
}
