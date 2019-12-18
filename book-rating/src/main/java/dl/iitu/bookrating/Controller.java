package dl.iitu.bookrating;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book/info")

public class Controller {

    @Autowired
    Repository repository;

    @GetMapping
    public String hello(){
        return "Hello, It's a Book info page";
    }

    @PostMapping("/{bookId}")
    public Rating createRating(@Valid @RequestBody Rating book) {
        return repository.save(book);
    }

    @GetMapping("/{bookId}")
    public Rating getRatingByBookId( @PathVariable("bookId") Long bookId)
            throws ResourceNotFoundException {
        Rating rating = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found for this id :: " + bookId));
        return rating;
    }

}
