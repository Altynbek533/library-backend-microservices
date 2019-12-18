package dl.iitu.userinfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "User")

public class User {

    public User() {}

    public User(Integer userId, String firstname, String lastname,
                String studentID, String groupID, String password){
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
        this.groupID = groupID;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;
    private String firstname;
    private String lastname;
    private String studentID;
    private String groupID;
    private String password;

    public Integer getUserid() { return userId; }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroupID() { return groupID; }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getStudentID() { return studentID; }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }
}
