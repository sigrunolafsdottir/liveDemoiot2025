package org.example.livedemoiot2025.book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookHTMLController {

    private BookRepository repo;

    public BookHTMLController(BookRepository repository) {
        this.repo = repository;
    }

    @RequestMapping("/addBook")
    public String addBookForm(){
        return "addBookByHTML.html";
    }


    @PostMapping("addBookByHTML")
    @ResponseBody
    public String addBook(@RequestParam String title,
                          @RequestParam String author){
        repo.save(new Book(title, author));
        return "Book added";
    }


}
