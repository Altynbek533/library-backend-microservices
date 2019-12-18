package dl.iitu.bookrating;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity

public class Rating {

    public Rating() {
    }

    public Rating(Long bookId, Integer rating, Integer votes) {
        this.bookId = bookId;
        this.rating = rating;
        this.votes= votes;
    }

    private Long bookId;
    private Integer rating;
    private Integer votes;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
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
