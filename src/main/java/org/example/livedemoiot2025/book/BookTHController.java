package org.example.livedemoiot2025.book;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookTHController {

    private BookRepository repo;

    public BookTHController(BookRepository repository) {
        this.repo = repository;
    }

    @RequestMapping("/allBooksByTH")
    public String getAll(Model model) {
        List<Book> books = repo.findAll();
        model.addAttribute("allBooks", books);
        model.addAttribute("label1", "Titlar");
        model.addAttribute("label2", "Författare");
        model.addAttribute("bookTitle", "Alla böcker");
        return "showAllBooks.html";
    }

    @RequestMapping("/allBooksByTHWithDeleteButton")
    public String getAllWithDeleteButton(Model model) {
        List<Book> books = repo.findAll();
        model.addAttribute("allBooks", books);
        model.addAttribute("label1", "Titlar");
        model.addAttribute("label2", "Författare");
        model.addAttribute("bookTitle", "Alla böcker");
        return "showAllBooksWithDeleteButton.html";
    }

    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        repo.deleteById(id);
        return getAllWithDeleteButton(model);
    }


    @RequestMapping("/searchBooks")
    public String search(Model model) {
        return "search.html";
    }

    @PostMapping("/doSearch")
    public String doSearch(@RequestParam String term, Model model) {
        List<Book> books = repo.findAll().stream()
                .filter(book -> term.equalsIgnoreCase(book.getTitle())
                        || term.equalsIgnoreCase(book.getAuthor())).toList();

        model.addAttribute("allBooks", books);
        model.addAttribute("label1", "Titlar");
        model.addAttribute("label2", "Författare");
        model.addAttribute("bookTitle", "Alla böcker");

        return "searchAndList.html";
    }


    /*
    @RequestMapping("/addBook")
    public String addBookForm(){
        return "addBookByHTML.html";
    }

    @PostMapping("addBookByTH")
    @ResponseBody
    public String addBook(@RequestParam String title,
                          @RequestParam String author){
        repo.save(new Book(title, author));
        return "Book added";
    }


    /*
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
*/

}
