package dl.iitu.libraryapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter

public class Borrow {

    public Borrow() {}

    public Borrow(Integer borrowID, Integer bookID, Integer userID, String dataStart, String dataEnd) {
        this.borrowID = borrowID;
        this.bookID = bookID;
        this.userID = userID;
        this.dataEnd = dataEnd;
        this.dataStart = dataStart;
    }


    @Id
    private Integer borrowID;
    private Integer bookID;
    private Integer userID;
    private String dataStart;
    private String dataEnd;

    public Integer getBorrowID() { return borrowID; }

    public Integer getBookID() { return bookID; }

    public Integer getUserID() { return userID; }

    public String getDataStart() { return dataStart; }

    public String getDataEnd() { return dataEnd; }

}

