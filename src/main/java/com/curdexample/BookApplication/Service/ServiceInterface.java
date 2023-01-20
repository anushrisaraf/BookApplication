package com.curdexample.BookApplication.Service;

import com.curdexample.BookApplication.Model.Book;

import java.util.List;

public interface ServiceInterface {



    List<Book> getBooks();
    Book addBook(Book book);
    Book getBookById(long isbnNo);
    List<Book> getByAuthorName(String authorName);
    String deleteBook(long isbnNo);

    Book updateBook(long isbnNo, Book book);

   /* Book GetBookByNo(long isbnNo);


    String DeleteBookByNo(long isbnNo);

    Book updateBook(long isbnNo,Book book);

    List<Book> searchByAuthorName(String authorName);

*/

}
