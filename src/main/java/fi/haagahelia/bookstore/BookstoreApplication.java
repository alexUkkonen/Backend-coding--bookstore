package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import fi.haagahelia.bookstore.storage.BookRepository;

import fi.haagahelia.bookstore.storage.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookRepository repository) {
		return args -> {
			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", new BigDecimal("10.99")));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", new BigDecimal("7.99")));
			repository.save(new Book("1984", "George Orwell", 1949, "9780451524935", new BigDecimal("9.99")));
		};
	
	}

}
