package dl.iitu.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    Repository userRepository;

    @GetMapping("/all")
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public User createBook(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public User getUsersById(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));
        return user;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserInfo(@PathVariable(value = "userId") Long userId,
                                               @Valid @RequestBody User userInfo) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));

        user.setFirstname(userInfo.getFirstname());
        user.setSurname(userInfo.getSurname());
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setPassword(userInfo.getPassword());
        final User updateUserInfo = userRepository.save(user);
        return ResponseEntity.ok(updateUserInfo);
    }

    @DeleteMapping("/{userId}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


