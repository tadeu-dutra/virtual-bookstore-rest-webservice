package br.com.facint.bookstore.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.facint.bookstore.model.Author;
import br.com.facint.bookstore.model.Book;

public class BookRepository {
    
    private Map<Long, Book> books = new HashMap<>();

    public BookRepository() {
        Author author1 = new Author(1L, "Mary");
        Author author2 = new Author(2L, "Jane");
        Book book1 = new Book(1L, "Book A", "ISBN-1234", "Genre A", 23.99, List.of(author1));
        Book book2 = new Book(2L, "Book B", "ISBN-4321", "Genre B", 19.99, List.of(author2));
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }
}
