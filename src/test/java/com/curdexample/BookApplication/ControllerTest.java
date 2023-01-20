package com.curdexample.BookApplication;



import com.curdexample.BookApplication.Controller.ControllerC;
import com.curdexample.BookApplication.Model.Book;
import com.curdexample.BookApplication.Service.ServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.librabry.book.entities.Book;
//import com.librabry.book.service.ServiceInterface;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class ControllerTest {

    Book book;
    @Autowired
    ServiceInterface serviceInterface;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ControllerC controller;

    @BeforeEach
    public void init(){
        book=new Book();
        book.setIsbnNo(1234567890);
        book.setBookName("science");
        book.setAuthorName("Sajal");
        book.setAuthorId(44);
        book.setYearOfPublication(2002);
    }
    @Order(1)
    @Test
    void addBookTestController() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        book.setIsbnNo(1234567890);
        this.mockMvc.perform(post("/books/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))).andExpect(status().isCreated());
    }

    @Order(2)
    @Test
    void searchByAuthorTestController() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        //book.setAuthorName("adarsh");
        //serviceInterface.addBook(book);
        this.mockMvc.perform(get("/books/getByAuthor/Sajal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))).andExpect(status().isOk());
    }
    @Order(3)
    @Test
    void getBookAll() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        // serviceInterface.addBook(book);
        this.mockMvc.perform(get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(book)))
                .andExpect(status().isAccepted());
    }

    @Order(4)
    @Test
    void updateBookTestController() throws Exception {
        // serviceInterface.addBook(book);
        ObjectMapper mapper=new ObjectMapper();
        this.mockMvc.perform(put("/books/update/1234567890")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))).andExpect(status().isCreated());
    }
    @Order(5)
    @Test
    public void deleteBook() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        //serviceInterface.addBook(book);
        this.mockMvc.perform(delete("/books/deleteBookByIsbnNo/1234567890")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(book)))
                .andExpect(status().isAccepted());
    }

}