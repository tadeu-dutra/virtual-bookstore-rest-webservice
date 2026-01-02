package br.com.facint.bookstore;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import br.com.facint.bookstore.exception.BookNotFoundException;
import br.com.facint.bookstore.model.Book;
import br.com.facint.bookstore.model.Catalog;
import br.com.facint.bookstore.repository.BookRepository;

@Path("book")
public class BookResource {
    
    private BookRepository bookRepository = new BookRepository();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Catalog getBooks() {
        Catalog catalog = new Catalog();
        catalog.setBooks(bookRepository.getBooks());
        return catalog;
    }

    @GET
    @Path("/{isbn}")
    public Book getBookByIsbn(@PathParam("isbn") String isbn) {

        try {
            return bookRepository.getBookByIsbn(isbn);
        } catch (BookNotFoundException e) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response addBook(Book book) {
        bookRepository.addBook(book);

        java.net.URI uriLocation = UriBuilder
            .fromPath("book/{isbn}")
            .build(book.getIsbn());

        return Response.created(uriLocation).entity(book).build();
    }
}
