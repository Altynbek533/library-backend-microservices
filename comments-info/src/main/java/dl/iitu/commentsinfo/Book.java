package dl.iitu.commentsinfo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Book {
    public Book() {}

    public Book(Long bookID, String name, String author, String description,
                Integer quantity, String status, String category) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.category = category;
    }

    private Long bookID;
    private String name;
    private String author;
    private String description;
    private Integer quantity;
    private String status;
    private String category;
}
