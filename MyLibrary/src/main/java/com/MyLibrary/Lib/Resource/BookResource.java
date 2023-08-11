package com.MyLibrary.Lib.Resource;

import com.MyLibrary.Lib.Model.Book;
import com.MyLibrary.Lib.Model.BookAuthorLetter;
import com.MyLibrary.Lib.Service.BookService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @GetMapping("/find/number/{iSBNNumber}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable("iSBNNumber") String iSBNNumber) {
        Book book = bookService.findByiSBNNumber(iSBNNumber);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/find/byBookName/{BookName}")
    public ResponseEntity<Book> getBookByBookName(@PathVariable("BookName") String bookName) {
        Book book = bookService.findByBookName(bookName);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("find/byId/{id}")
    public ResponseEntity<Book> findbyid(@PathVariable("id")Number id){
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @GetMapping("/find/ownersNickNames/ {OwnersNickNames}")
    public ResponseEntity<List<Book>> getBookbyOwnersNickNames(@PathVariable("ownersNickNames") String ownersNickNames){
    List<Book> books = bookService.findByownersNickNames("RichieRich");
    return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/find/byAuthorName/{AuthorName}")
    public ResponseEntity<List<Book>> getBookByAuthorName(@PathVariable("AuthorName") String authorName) {
        List<Book> books = bookService.findByAuthorName(authorName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateMember(@RequestBody Book book) {
        Book updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{iSBNNumber}")
    public ResponseEntity<?> deleteBookByISBNNumber(@PathVariable("iSBNNumber") String iSBNNumber) {
        bookService.deleteBookByiSBN(iSBNNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/byAuthorFirstLetter")
    public ResponseEntity<List<BookAuthorLetter>> getBookListByAuthorFirstLetter(){
        List<BookAuthorLetter> books = bookService.getBookListByAuthorFirstLetter();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
