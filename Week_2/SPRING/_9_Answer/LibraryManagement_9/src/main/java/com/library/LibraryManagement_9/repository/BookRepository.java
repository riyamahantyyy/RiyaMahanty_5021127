package com.library.LibraryManagement_9.repository;

import com.library.LibraryManagement_9.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
