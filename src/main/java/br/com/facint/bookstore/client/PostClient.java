package br.com.facint.bookstore.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.facint.bookstore.model.Author;
import br.com.facint.bookstore.model.Book;
import br.com.facint.bookstore.model.SearchItem;

public class PostClient {
    
    public static void main(String[] args) {
        Author author1 = new Author(1L, "Author 1");
        Book book1 = new Book(3L, "Book C", "ISBN-9876", "Genre C", 23.99, List.of(author1));

        Response response = ClientBuilder.newClient()
                            .target("http://localhost:8080/virtual-bookstore")
                            .path("book")
                            .request()
                            .post(Entity.xml(book1));
            
        if (response.getStatus() == Status.CREATED.getStatusCode()) {

            SearchItem item = ClientBuilder.newClient()
                                .target(response.getLocation())
                                .request(MediaType.APPLICATION_XML)
                                .get(SearchItem.class);
            System.out.println(item.getBook().getTitle());

        } else if (response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
            System.out.println("Please verify if data is correct..");
        }   
    }
}
