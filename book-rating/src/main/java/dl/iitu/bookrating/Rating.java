package dl.iitu.bookrating;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Book")

public class Rating {

    public Rating() {
    }

    public Rating(Integer bookId, Integer rating, Integer votes) {
        this.bookId = bookId;
        this.rating = rating;
        this.votes= votes;
    }

    private Integer bookId;
    private Integer rating;
    private Integer votes;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }
}
