package dl.iitu.libraryapi.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

@Getter
@Setter

public class User {

    public User() {
    }

    public User(Integer userId, String firstname, String lastname,
                String studentID, String groupID, String password) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
        this.groupID = groupID;
        this.password = password;
    }

    @Id
    private Integer userId;
    private String firstname;
    private String lastname;
    private String studentID;
    private String groupID;
    private String password;

    public Integer getUserid() {
        return userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroupID() {
        return groupID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getPassword() {
        return password;
    }

}
