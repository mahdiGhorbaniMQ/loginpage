package ir.ghorbani.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
public class TheController {

    private final UserRepository userRepository;

    public TheController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("test")
    public String test() {
        return "hellooo";
    }

    @GetMapping("addUser")
    public void getUsers(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String email,
                         @RequestParam String username,
                         @RequestParam String password) {
        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.eMail = email;
        user.userName = username;
        user.password = password;
        userRepository.save(user);
    }

//    @PutMapping("addUser")
//    public User updateUser(@RequestBody User user){
//        return userRepository.save(user);
//    }

    @GetMapping("getUser")
    public ResponseEntity<User> getByUserName(@RequestParam String username,
                                              @RequestParam String password) {
        User user = userRepository.findByUserName(username);
        if (user.password.equals(password))
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.badRequest().build();
    }


}
