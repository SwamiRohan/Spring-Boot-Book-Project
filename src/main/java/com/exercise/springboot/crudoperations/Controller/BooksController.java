package com.exercise.springboot.crudoperations.Controller;

import com.exercise.springboot.crudoperations.Service.BooksService;
import com.exercise.springboot.crudoperations.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BooksService booksService;
    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/books")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }
    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/books/{bookId}")
    private Books getBooks(@PathVariable("bookId")int bookId)
    {
        return booksService.getBooksById(bookId);
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/books/{bookId}")
    private void deleteBook(@PathVariable("bookId") int bookId)
    {
        booksService.delete(bookId);
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books.getBookId();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books;
    }
}
