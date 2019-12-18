package dl.iitu.bookinfo.Book;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
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

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long bookID;
    private String name;
    private String author;
    private String description;
    private Integer quantity;
    private String status;
    private String category;

}
