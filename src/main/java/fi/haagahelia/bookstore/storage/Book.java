package fi.haagahelia.bookstore.storage;

import java.math.BigDecimal;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private BigDecimal price;

    public Book(String title, String author, int publicationYear, String isbn, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }
    
}
