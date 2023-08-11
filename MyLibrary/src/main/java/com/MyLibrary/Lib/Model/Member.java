package com.MyLibrary.Lib.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@Document
public class Member{
    @Id
    private BigInteger id;

    @Field
    private String firstName;
    @Indexed(unique = true)
    private String email;

    @Field
    private String password;
    @Indexed(unique = true)
    private  String nickName;

    @Field
    private Integer age;

    @Field
    private Integer bookCount;

    @Field
    private List<String> ownedBookNames;
    @Field
    private String role;


    public Member(String firstName,
                  String email,
                  String password,
                  String nickName,
                  Integer age,
                  Integer bookCount,
                  List<String> ownedBookNames,
                  String role) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.age = age;
        this.bookCount = bookCount;
        this.ownedBookNames = ownedBookNames;
        this.role = role;
    }

    public String getNickName() {
        return nickName;
    }
}
