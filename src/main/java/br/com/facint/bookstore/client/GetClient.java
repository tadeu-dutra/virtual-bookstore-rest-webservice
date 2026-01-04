package br.com.facint.bookstore.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import br.com.facint.bookstore.model.Book;
import br.com.facint.bookstore.model.Catalog;

public class GetClient {
    
    public static void main(String[] args) {
        Catalog catalog = ClientBuilder.newClient()
                        .target("http://localhost:8080/virtual-bookstore")
                        .path("book")
                        .request(MediaType.APPLICATION_XML)
                        .get(Catalog.class);

        for (Book book : catalog.getBooks()) {
            System.out.println(book.getTitle());
        } 
    }
}
