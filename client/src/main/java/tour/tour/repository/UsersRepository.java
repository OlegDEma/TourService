package tour.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tour.tour.entity.User;

@Repository("userRepository")
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findOneByUsername(String userName);
}
