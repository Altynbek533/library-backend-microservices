package dl.iitu.libraryapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter

public class Book {

    public Book(int i, String aNull, String s, String aNull1, String s1) {}

    public Book(Integer bookID, String name, String author, String description,
                Integer quantity, String status, String category) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.category = category;
    }

    @Id
    private Integer bookID;
    private String name;
    private String author;
    private String description;
    private Integer quantity;
    private String status;
    private String category;

    public Integer getBookID() { return bookID; }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }
}
