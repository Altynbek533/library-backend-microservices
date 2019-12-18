package kz.iitu.jd3.notifyservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long bookID;
    private String name;
    private String author;
    private String description;
    private Integer quantity;
    private String status;
    private String category;



    @Override
    public String toString() {
        return "Product{" +
                "bookID=" + bookID +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
