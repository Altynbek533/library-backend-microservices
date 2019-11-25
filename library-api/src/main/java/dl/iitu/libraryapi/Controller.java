package dl.iitu.libraryapi;


import dl.iitu.libraryapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;


//    @GetMapping("/{bookID}")
//    public List<Catalog> getAllBooks(@PathVariable Integer bookID){
//
//        Book book = restTemplate.getForObject(
//                "http://localhost:8082/book/" + bookID, Book.class);
//
//        List<Catalog> bookList = new ArrayList<>();
//
//        Rating rate = restTemplate.getForObject(
//                "http://localhost:8083/rating/" + book.getBookID(), Rating.class);
//
//        bookList.add(new Catalog(book.getBookID(), book.getName(), book.getAuthor(),
//                book.getStatus(), rate.getRating()));
//
//        return bookList;
//    }
//
//    @GetMapping("/{userId}")
//    public List<Table> getAllUsers(@PathVariable Integer userId) {
//        User user = restTemplate.getForObject(
//                "http://localhost:8085/users/" + userId, User.class);
//
//
//        List<Table> userList = new ArrayList<>();
//
//        Borrow borrow = restTemplate.getForObject(
//                "http://localhost:8085/borrow/" + user.getUserid(), Borrow.class);
//
//        userList.add( new Table(user.getUserid(), user.getFirstname(),user.getLastname(),
//                borrow.getDataEnd(), borrow.getDataStart(), borrow.getBookID()));
//
//        return userList;
//    }
//
//    @SuppressWarnings("unused")
//    private List<Book> getAllGames_Fallback() {
//
//        System.out.println("Game Service is down!!! fallback route enabled...");
//        List<Book> list =  Arrays.asList(
//                new Book("No Response From Game Service at this moment","NULL","NULL"));
//        return list;
////        return "CIRCUIT BREAKER ENABLED!!! No Response From Game Service at this moment. " +
////                " Service will be back shortly - " + new Date();
//    }
//
//    @SuppressWarnings("unused")
//    private Book getGames_Fallback(Long id) {
//
//        System.out.println("Book Service is down!!! fallback route enabled...");
//        Book list=new Book(0,"null","null","null",0);
//        return list;
//    }
}
