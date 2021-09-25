package com.app.demo1.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "books")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class BooksEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name="book_id")
    private Integer booksId;
    @Column(name="book_name")
    private String BookName;
    @Type(type="json")
   @Column(name="book_details", columnDefinition = "json")
    private Map<String, List<String>> bookDetails;

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public Map<String, List<String>> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(Map<String, List<String>> bookDetails) {
        this.bookDetails = bookDetails;
    }

    @Override
    public String toString() {
        return "BooksEntity{" +
                "booksId=" + booksId +
                ", BookName='" + BookName + '\'' +
                ", bookDetails=" + bookDetails +
                '}';
    }

   /* public static void main(String[] args) throws JsonProcessingException {
        Map<String, List<String>> x1 = new HashMap<>();
        x1.put("abc", Arrays.asList("ten", "twenty"));
        x1.put("xyz", Arrays.asList("ttt", "yyy"));
        x1.put("aaa", Arrays.asList("ttt", "yyy"));
        BooksEntity booksEntity = new BooksEntity();
        booksEntity.setBooksId(1234);
        booksEntity.setBookName("hello");
        booksEntity.setBookDetails(x1);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(booksEntity);
        System.out.println(jsonString.toString());
    }*/
}
