package dl.iitu.libraryapi.model;

public class Catalog {
    public Catalog(Integer bookID, String status, String author, String name, Integer rating) {
        this.bookID = bookID;
        this.status = status;
        this.name = name;
        this.author = author;
        this.rating = rating;
    }

    private Integer bookID;
    private Integer rating;
    private Integer votes;

    private String name;
    private String author;
    private String description;
    private Integer quantity;
    private String status;
    private String category;

}
