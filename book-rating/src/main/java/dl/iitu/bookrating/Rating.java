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

}
