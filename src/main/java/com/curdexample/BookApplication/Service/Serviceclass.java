package com.curdexample.BookApplication.Service;

import com.curdexample.BookApplication.BookException.EmptyListException;
import com.curdexample.BookApplication.BookException.InvalidEntryException;
import com.curdexample.BookApplication.Model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Serviceclass implements ServiceInterface {




        Logger logger = LoggerFactory.getLogger(Controller.class);

        List<Book> Booklist = new ArrayList<Book>();

    public Serviceclass()
    {

    }

        @Override
        public List<Book> getBooks() {
        logger.info("getting list of books  from library ");
        if (Booklist.isEmpty()) {
            throw new EmptyListException("List is empty");
            //System.out.println("Exception thrown for empty list of books");

        }
           // System.out.println("Exception thrown for empty list of books");
        return Booklist;
    }




    @Override
    public Book addBook(Book book){
        for(Book bookobj:Booklist){//todo
            if( book.getIsbnNo()==bookobj.getIsbnNo())
                throw new InvalidEntryException("same book is already present ");
        }
        String isbnLen=String.valueOf(book.getIsbnNo());
        if(isbnLen.length()!=10) {
            throw new InvalidEntryException("IsbnNumber must be of 10 digits...");}
        if(!(book.getBookName().length()>4)&&(book.getBookName()!=null)) {
            throw new InvalidEntryException("length of Book Name must be more than 4 character ..");}
        if(!(book.getYearOfPublication()>1980)){
            throw new InvalidEntryException("this System only accepts entry of Book that are Publish after 1980");}
        else Booklist.add(book);
        logger.info("Book successfully added "+book);//todo-done
        return book;//todo-done
    }




    public Book getBookById(long IsbnoById)
  {
      Book b= null;
      for(Book bj:Booklist)
      {
          if(bj.getIsbnNo()==IsbnoById)
          {
              b=bj;
              break;
          }

      }
      if(b==null)
      {
          throw new InvalidEntryException("Please Enter Valid Id");
      }
    logger.info("Get book with Id");
      return b;
  }



  public List<Book> getByAuthorName(String authorName)
  {
      List<Book> b =new ArrayList<>();
      for(Book bj:Booklist)
      {
          if(bj.getAuthorName().equalsIgnoreCase(authorName))
          {
              b.add(bj);
              break;
          }
      }
      if(b.isEmpty())
      {
          throw new EmptyListException("List is Empty");
      }

      return b;
  }


    public String deleteBook(long isbnNo){
        Book book=null;
        for (Book bookObj : Booklist) {
            if (bookObj.getIsbnNo() == isbnNo) {
                book=bookObj;
                Booklist.remove(bookObj);
                break;
            }}
        if(book==null)
        { throw new InvalidEntryException("Invalid ISBN Number or No book is present with this IsbnNo "+isbnNo);}
        logger.info("Book deleted");
        return "deleted";
    }

    public Book updateBook(long isbnNo, Book book) {
        Serviceclass service=new Serviceclass();
        for (Book bookObj : Booklist) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setIsbnNo(isbnNo);//todo-done
                bookObj.setBookName(book.getBookName());
                bookObj.setAuthorName(book.getAuthorName());
                bookObj.setAuthorId((book.getAuthorId()));
                bookObj.setYearOfPublication((book.getYearOfPublication()));
                service.addBook(bookObj);
                break;
            }
        }
        logger.info("successfully updated the existing entry ");
        return book;

    }


}
