package controller;

import model.Book;
import repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(produces = { "application/json", "application/xml" })
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping(value = "/{id}", consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            Book updatedBook = book.get();
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setAuthor(bookDetails.getAuthor());
            updatedBook.setPrice(bookDetails.getPrice());
            updatedBook.setIsbn(bookDetails.getIsbn());
            bookRepository.save(updatedBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
