package br.com.facint.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlAttribute
    private Long id;

    @XmlElement
    private String title;

    @XmlElement
    private String isbn;

    @XmlElement
    private String genre;

    @XmlElement
    private Double price;

    @XmlElement
    private List<Author> author = new ArrayList<Author>();

    public Book() {}

    public Book(Long id, String title, String isbn, String genre, Double price, List<Author> author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }

    public Long getId() {
        return id;
    }
}
