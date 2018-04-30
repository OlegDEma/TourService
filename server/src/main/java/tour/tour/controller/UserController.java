package tour.tour.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tour.tour.entity.User;
import tour.tour.repository.UsersRepository;
import tour.tour.service.UserService;
import tour.tour.util.CustomErrorType;




@RestController
@RequestMapping("/api/users")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UsersRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    public UserController(UsersRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody User newUser) {
        if (userService.find(newUser.getUsername()) != null) {
            logger.error("username Already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");
        return new ResponseEntity<User>(userService.addUser(newUser), HttpStatus.CREATED);
    }

}