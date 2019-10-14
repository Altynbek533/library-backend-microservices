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

    @PostMapping("/add")
    public Rating createRent(@Valid @RequestBody Rating book) {
        return repository.save(book);
    }

    @GetMapping("/{bookId}")
    public Rating getRatingByBookId( @PathVariable("bookId") Integer bookId)
            throws ResourceNotFoundException {
        Rating rating = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));
        return rating;
    }

    @DeleteMapping("/book/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer bookId)
            throws ResourceNotFoundException {
        Rating book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));

        repository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
