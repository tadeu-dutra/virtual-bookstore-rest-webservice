package br.com.facint.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "searchItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchItem {
    
    @XmlElement
    private Book book;

    @XmlElement
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links = new ArrayList<Link>();

    public SearchItem() {}

    public void addLimk(Link link) {
        links.add(link);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Link> getLinks() {
        return links;
    }
}
