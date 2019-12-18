package kz.iitu.jd3.datarequest;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    private String userId;
    private Book book;

    public BookRequest() {
    }

    public BookRequest(String userId, Book book) {
        this.userId = userId;
        this.book = book;
    }


    @Override
    public String toString() {
        return "BookRequest{" +
                "userId='" + userId + '\'' +
                ", post=" + book +
                '}';
    }
}
