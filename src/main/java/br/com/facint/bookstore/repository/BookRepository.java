package br.com.facint.bookstore.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.facint.bookstore.exception.BookExistentException;
import br.com.facint.bookstore.exception.BookNotFoundException;
import br.com.facint.bookstore.model.Author;
import br.com.facint.bookstore.model.Book;

public class BookRepository {
    
    private static Map<Long, Book> books = new HashMap<>();

    public BookRepository() {
        Author author1 = new Author(1L, "Author 1");
        Author author2 = new Author(2L, "Author 2");
        Book book1 = new Book(1L, "Book A", "ISBN-1234", "Genre A", 23.99, List.of(author1));
        Book book2 = new Book(2L, "Book B", "ISBN-4321", "Genre B", 19.99, List.of(author2));
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookByIsbn(String isbn) {
        
        for (Book book : books.values()) {
            if (isbn.equals(book.getIsbn())) {
                return book;
            }
        }

        throw new BookNotFoundException();
    }

    public void addBook(Book book) {
        
        if (books.containsKey(book.getId())) {
            throw new BookExistentException();
        }
        
        books.put(book.getId(), book);
    }

    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }
}
