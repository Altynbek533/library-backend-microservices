package dl.iitu.bookrating;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Rating, Integer> {
}
