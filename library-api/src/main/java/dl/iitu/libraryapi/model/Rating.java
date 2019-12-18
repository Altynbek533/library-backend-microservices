package dl.iitu.libraryapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Rating {

    public Rating() {
    }

    public Rating(String bookId, Integer rating, Integer votes) {
        this.bookId = bookId;
        this.rating = rating;
        this.votes= votes;
    }

    private String bookId;
    private Integer rating;
    private Integer votes;

    public Integer getRating() {
        return rating;
    }

    public String getBookId() {
        return bookId;
    }

    public Integer getVotes() {
        return votes;
    }
}
