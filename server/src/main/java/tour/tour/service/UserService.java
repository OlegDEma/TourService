package tour.tour.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import tour.tour.entity.User;

import java.util.List;

public interface UserService {

     User addUser(User user);

     void removeUser(User user);

     void removeById(int id);

     User findOne(int id);

     User find(String userName);

      User save(User user);

     User findByNickName(String name);

     void updateUser(User user);

     List<User> findAll();

     List<User> findAllSorted(Sort sort);

     Page<User> findAllPageble(Pageable pageable);

     User findUserByEmail(String email);

     User findUserByEmailAndPassword(String email, String password);

}
