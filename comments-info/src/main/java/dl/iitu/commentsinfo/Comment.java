package dl.iitu.commentsinfo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Comment {

    public Comment() {}

    public Comment(Long commentId, Long bookID, Long userId, String comment, Date creatAt) {
        this.commentId = commentId;
        this.userId = userId;
        this.bookID = bookID;
        this.comment = comment;
        this.creatAt = creatAt;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long commentId;
    private Long bookID;
    private Long userId;
    private String comment;
    private Date creatAt;
}
