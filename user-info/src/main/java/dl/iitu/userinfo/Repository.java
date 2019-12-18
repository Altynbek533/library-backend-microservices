package dl.iitu.userinfo;

import dl.iitu.userinfo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Integer> {
}
