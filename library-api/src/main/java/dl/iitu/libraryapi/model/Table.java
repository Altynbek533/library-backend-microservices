package dl.iitu.libraryapi.model;

public class Table {

    public Table(Integer userId, String firstname, String lastname,
                 String dataEnd, String dataStart, Integer bookID) {
        this.borrowID = borrowID;
        this.bookID = bookID;
        this.userID = userID;
        this.dataEnd = dataEnd;
        this.dataStart = dataStart;

        this.firstname =firstname;
        this.lastname = lastname;
    }

    private Integer borrowID;
    private Integer bookID;
    private Integer userID;

    private String dataStart;
    private String dataEnd;

    private String firstname;
    private String lastname;
    private String studentID;
    private String groupID;
    private String password;

}
