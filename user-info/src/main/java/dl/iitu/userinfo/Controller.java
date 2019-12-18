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
@RequestMapping("/user/info")
public class Controller {

    @Autowired
    Repository repository;

    @GetMapping("/all")
    public List<User> allUser() {
        return repository.findAll();
    }

    @PostMapping("/addUser")
    public User createBook(@Valid @RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUsersById(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));
        return user;
    }

    @PutMapping("/user/info/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable(value = "id") Integer userId,
                                               @Valid @RequestBody User userInfo) throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));

        user.setUserId(userInfo.getUserid());
        user.setFirstname(userInfo.getFirstname());
        user.setLastname(userInfo.getLastname());
        user.setStudentID(userInfo.getStudentID());
        user.setGroupID(userInfo.getGroupID());
        user.setPassword(userInfo.getPassword());
        final User updateUserInfo = repository.save(user);
        return ResponseEntity.ok(updateUserInfo);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + userId));

        repository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}



//        List<User> list = Arrays.asList(
//                new User(1 , "Kenges", "Altynbek", "IS1602K", "21094", "qwerty"),
//                new User(2 , "Bolatov", "Sanjar", "IS1605K", "21240", "1234567")
//        );
//
//
//
//        for (User userList : list){
//            if (userList.getUserid().equals(userId)){
//                return userList;
//            }
//        }
//
//        return null;


