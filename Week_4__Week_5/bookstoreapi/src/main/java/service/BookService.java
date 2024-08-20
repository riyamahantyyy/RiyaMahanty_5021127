package service;

import model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }
    public List<Book> searchBooks(String title, String author) {
        return books.stream()
                .filter(book -> (title == null || book.getTitle().contains(title)) &&
                        (author == null || book.getAuthor().contains(author)))
                .collect(Collectors.toList());
    }

    public Book createBook(Book book) {
        book.setId((long) (books.size() + 1));
        books.add(book);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = findBookById(id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            existingBook.setIsbn(book.getIsbn());
        }
        return existingBook;
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    private Book findBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
    public Book getBookById(Long id) {
        return findBookById(id);
    }

}
