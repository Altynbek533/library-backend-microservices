package dl.iitu.bookinfo.Book;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/book")
public class Controller {

    @Autowired
    Repository bookRepository;

    @GetMapping
    public String hello(){
        return "Hello, It's a Book info page";
    }

    @GetMapping("/all")
    public List<Book> allBook(){
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable(value = "bookId") Long bookId)throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + bookId));
        return book;
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBookInfo(@PathVariable(value = "bookId") Long bookId,
                                           @Valid @RequestBody Book bookInfo) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));

        book.setBookID(bookInfo.getBookID());
        book.setAuthor(bookInfo.getAuthor());
        book.setCategory(bookInfo.getCategory());
        book.setDescription(bookInfo.getDescription());
        book.setName(bookInfo.getName());
        book.setQuantity(bookInfo.getQuantity());
        book.setStatus(bookInfo.getStatus());
        final Book updateBookInfo = bookRepository.save(book);
        return ResponseEntity.ok(updateBookInfo);
    }

    @DeleteMapping("/{bookId}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "bookId") Long bookId)
            throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


