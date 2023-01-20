package com.curdexample.BookApplication.Controller;

import com.curdexample.BookApplication.Model.Book;
import com.curdexample.BookApplication.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerC {
    @Autowired
    private ServiceInterface serviceinterface;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooks() { //todo-done

        return this.serviceinterface.getBooks();
    }


    @PostMapping("/books/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book)
    {
        return this.serviceinterface.addBook(book);
    }

    @GetMapping("/books/getByAuthor/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getByAuthorName(@PathVariable String author){
        return this.serviceinterface.getByAuthorName(author);
    }




    @DeleteMapping("/books/deleteBookByIsbnNo/{isbnNo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBook(@PathVariable long isbnNo) {
        return this.serviceinterface.deleteBook(isbnNo);
    }
    @PutMapping("/books/update/{isbnNo}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book updateBook(@PathVariable long isbnNo,@RequestBody Book book) {
        return serviceinterface.updateBook(isbnNo,book);
    }
}
