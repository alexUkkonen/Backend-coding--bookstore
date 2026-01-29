package fi.haagahelia.bookstore.storage;

import java.math.BigDecimal;

public class Book {
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
}
