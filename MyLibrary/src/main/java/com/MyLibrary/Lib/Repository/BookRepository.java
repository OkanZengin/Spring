package com.MyLibrary.Lib.Repository;
import com.MyLibrary.Lib.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByiSBNNumber(String iSBNNumber);
    Optional <Book> findByBookName(String bookName);

    List<Book> findByAuthorName(String authorName);
    void deleteBookByiSBNNumber(String iSBNNumber);

    List<Book> findByOwnersNickNames(String ownersNickNames);
    Optional<Book> findById(Number id);
    List<Book> findByAuthorNameStartingWithIgnoreCase(String letter);


}
