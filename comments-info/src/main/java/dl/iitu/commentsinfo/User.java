package dl.iitu.commentsinfo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class User {
    public User() {}

    public User(Long userId, String firstname, String surname,
                String username, String email, String password){
        this.userId = userId;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private Long userId;
    private String firstname;
    private String surname;
    private String username;
    private String email;
    private String password;
}
