package com.MyLibrary.Lib.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Data
@Document
public class Book {
    @Id
    private BigInteger id;
    private String bookName;
    private String authorName;
    private Integer publishedWhen;
    @Indexed(unique = true)
    private String iSBNNumber;
    private List<String> ownersNickNames;
    private String imgUrl;

    public Book(String bookName, String authorName, Integer publishedWhen, String iSBNNumber, List<String> ownersNickNames, String imgUrl) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedWhen = publishedWhen;
        this.iSBNNumber = iSBNNumber;
        this.ownersNickNames = ownersNickNames;
        this.imgUrl = imgUrl;
    }

    public String getBookName() {
        return bookName;
    }
}
