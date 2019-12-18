package kz.iitu.jd3.datarequest;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Book {

    private String bookID;
    private String name;
    private String author;
    private String description;
    private String quantity;
    private String status;
    private String category;

    public Book() {
    }

    public Book(String bookID) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.category = category;
    }

}
