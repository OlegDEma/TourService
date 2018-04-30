package tour.tour.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import tour.tour.entity.User;
import tour.tour.service.UserService;
import tour.tour.util.CustomErrorType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@RestController
@RequestMapping("/account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
	private UserDetailsService userDetailsService;

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ResponseEntity<?> createUser(@RequestBody User newUser) {
////        User newUser = new User();
////        newUser.setFirstName("Oleg");
////        newUser.setLastName("Dema");
////        newUser.setUsername("OlegDema");
////        newUser.setPassword("d09111997");
////        newUser.setPatronymic("Olex");
////        newUser.setEmail("demaoleg78@gmail.com");
//        System.out.println(newUser);
//        if (userService.find(newUser.getUsername()) != null) {
//            logger.error("username Already exist " + newUser.getUsername());
//            return new ResponseEntity(
//                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
//                    HttpStatus.CONFLICT);
//        }
//        newUser.setRole("USER");
//
//        return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
//    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody User newUser) {
        System.out.println("EZ");
        if (userService.find(newUser.getUsername()) != null) {
            logger.error("username Already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
                    HttpStatus.CONFLICT);
        }
        newUser.setRole("USER");
        return new ResponseEntity<User>(userService.addUser(newUser), HttpStatus.CREATED);
    }


	@RequestMapping("/login")
	public User user(Principal principal) {
		logger.info("user logged "+principal);
        User user = userService.find(principal.getName());
        System.out.println(user);
		return user;
	}

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("LOGOUT");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "ok";
    }

    @GetMapping("/principal")
    public String logoutPage (Principal principal ,UsernamePasswordAuthenticationToken token) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal());
        System.out.println(token.getPrincipal());
        System.out.println(principal.getName());
        return "ok";
    }
	
	
}
