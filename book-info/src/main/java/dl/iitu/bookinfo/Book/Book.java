package dl.iitu.bookinfo.Book;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Book")

public class Book {

    public Book() {}

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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer bookID;
    private String name;
    private String author;
    private String description;
    private Integer quantity;
    private String status;
    private String category;

    public Integer getBookID() { return bookID; }
    public void setBookID(Integer bookID) { this.bookID = bookID; }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
