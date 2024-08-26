

import model.Book;
import repository.BookRepository;
import service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import controller.BookController;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BookController(bookService)).build();
    }

    @Test
    public void whenGetAllBooks_thenReturnBooks() throws Exception {
        bookRepository.save(new Book("Title1", "Author1", 10.0, "1234567890"));
        bookRepository.save(new Book("Title2", "Author2", 15.0, "0987654321"));

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Title1")))
                .andExpect(jsonPath("$[1].title", is("Title2")));
    }

    @Test
    public void whenCreateBook_thenBookIsCreated() throws Exception {
        String bookJson = "{\"title\":\"New Book\",\"author\":\"New Author\",\"price\":25.0,\"isbn\":\"1122334455\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("New Book")));
    }
}
