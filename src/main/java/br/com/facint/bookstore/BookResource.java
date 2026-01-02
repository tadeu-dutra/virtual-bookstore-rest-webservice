package br.com.facint.bookstore;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.facint.bookstore.model.Book;
import br.com.facint.bookstore.repository.BookRepository;

@Path("book")
public class BookResource {
    
    private BookRepository bookRepository = new BookRepository();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }
}
