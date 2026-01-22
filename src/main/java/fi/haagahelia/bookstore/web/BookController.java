package fi.haagahelia.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;

public class BookController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
