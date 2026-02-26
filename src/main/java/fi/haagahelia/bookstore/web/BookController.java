package fi.haagahelia.bookstore.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import fi.haagahelia.bookstore.storage.BookRepository;
import fi.haagahelia.bookstore.storage.CategoryRepository;
import fi.haagahelia.bookstore.storage.Book;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
public class BookController {

    private final CategoryRepository categoryRepository;

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "bookList";
    }

    @GetMapping("/addbook") // Simple get mapping to add a new book
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/savebook") // Post mapping to save added book
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).orElse(null));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }
    
    @GetMapping("/books")
    public @ResponseBody List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();   
    }

    @GetMapping("/book/{id}")
        public @ResponseBody Book getBookById(@PathVariable("id") Long id) {
            return bookRepository.findById(id).orElse(null);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    
    
    
    

}
