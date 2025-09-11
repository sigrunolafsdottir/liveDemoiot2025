package org.example.livedemoiot2025.book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookRepository repository) {
        this.repo = repository;
    }


    @RequestMapping("/books")
    public List<Book> getALlBooks(){
        logger.info("all books listed");
        return repo.findAll();
    }

    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return repo.findById(id).get();
    }

    @RequestMapping("/books/byTitle/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return repo.findByTitle(title);
    }

    @RequestMapping("/books/delete/{id}")
    public List<Book> deleteBookById(@PathVariable Long id){
        repo.deleteById(id);
        logger.warn("book was deleted");
        return repo.findAll();
    }

    @PostMapping("/book/add")
    public String addBook(@RequestBody Book b){
        repo.save(b);
        logger.info("book was added");
        return "Book added";
    }


}
