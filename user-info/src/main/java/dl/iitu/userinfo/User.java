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

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    private String firstname;
    private String surname;
    private String username;
    private String email;
    private String password;

}
