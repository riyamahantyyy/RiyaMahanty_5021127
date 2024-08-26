package repository;

import model.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAll();

	Book save(Book updatedBook);

	Optional<Book> findById(Long id);

	
}
