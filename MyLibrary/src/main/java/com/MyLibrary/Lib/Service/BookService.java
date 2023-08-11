package com.MyLibrary.Lib.Service;

import com.MyLibrary.Lib.Exception.BookNotFoundException;
import com.MyLibrary.Lib.Model.Book;
import com.MyLibrary.Lib.Model.BookAuthorLetter;
import com.MyLibrary.Lib.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static Book getBook() {
        return getBook();
    }

    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBookByiSBN(String iSBNNumber) {
        bookRepository.deleteBookByiSBNNumber(iSBNNumber);
    }

    public Book findById(Number id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("Book not found")
        );
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findByiSBNNumber(String iSBNNumber) {
        return bookRepository.findByiSBNNumber(iSBNNumber).orElseThrow(
                () -> new BookNotFoundException("Book not found")
        );
    }
    public List<Book> findByownersNickNames(String ownersNickNames){
        return bookRepository.findByOwnersNickNames(ownersNickNames);
    }

    public Book findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName).orElseThrow(
                () -> new BookNotFoundException("Book not found")
        );
    }

    public List<Book> findByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    public List<BookAuthorLetter> getBookListByAuthorFirstLetter(){
        List<String> letters = new ArrayList<>(Arrays.asList("a", "b", "c", "ç", "d", "e", "f", "g", "h", "ı", "i",
        "j", "k", "l", "m", "n", "o", "ö", "p", "r", "s", "ş", "t", "u", "ü", "v", "w","x", "q", "y", "z"));
        List<BookAuthorLetter> bookAuthorLetters = new ArrayList<>();
        letters.forEach(letter -> {
        List<Book> books = bookRepository.findByAuthorNameStartingWithIgnoreCase(letter.toUpperCase());
        if(books.size()!=0) {
            BookAuthorLetter bookAuthorLetter = new BookAuthorLetter();
            bookAuthorLetter.setLetter(letter);
            bookAuthorLetter.setBooks(books);
            bookAuthorLetters.add(bookAuthorLetter);
        }
        });
        return bookAuthorLetters;
    }

}
