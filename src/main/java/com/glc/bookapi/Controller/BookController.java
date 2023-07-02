package com.glc.bookapi.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.bookapi.Model.Book;
import com.glc.bookapi.Repository.BookRepository;


@RestController
@RequestMapping("/books") // http://localhost:8080/books
@CrossOrigin(origins = "http://localhost:3000") 

public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

   @GetMapping("/getall")  // http://localhost:8080/books/getall
   public List<Book> getAllBooks() {
         return bookRepository.findAll();
   }
   @PostMapping("/add")   // http://localhost:8080/books/add
   public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
   }
   @GetMapping("/getbyid/{id}") // http://localhost:8080/books/getbyid/{id}
   public Book getBookById(@PathVariable Long id) {
    return bookRepository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));
   }
   @PutMapping("/update/{id}") // http://localhost:8080/books/update/{id} 
   public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) throws IllegalAccessException{
    Book book  = bookRepository.findById(id)
    .orElseThrow(() -> new IllegalAccessException("Invalid book ID: " + id));

    book.setTitle(updatedBook.getTitle());
    book.setAuthor(updatedBook.getAuthor());

    return bookRepository.save(book);
   }
   @DeleteMapping("/delete/{id}")  // http://localhost:8080/books/delete/{id} 
   public void deleteBook(@PathVariable Long id) {
      bookRepository.deleteById(id);
   }


}
