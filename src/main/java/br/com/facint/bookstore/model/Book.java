package br.com.facint.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
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
    @JsonbTransient
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }
}
