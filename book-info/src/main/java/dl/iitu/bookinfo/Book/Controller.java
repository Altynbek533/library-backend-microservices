package dl.iitu.bookinfo.Book;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/book/info")
@EnableHystrix

public class Controller {

    @Autowired
    Repository repository;

    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })

    @GetMapping
    public String hello(){
        return "Hello, It's rent page";
    }

    @GetMapping("/all")
    public List<Book> allBook(){
        return repository.findAll();
    }

    @PostMapping("/add")
    public Book createBook(@Valid @RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/rents/{id}")
    public Book getBooksById(@PathVariable(value = "id") Integer bookId)
            throws ResourceNotFoundException {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));
        return book;
    }

    @PutMapping("/book/info/{id}")
    public ResponseEntity<Book> updateBookInfo(@PathVariable(value = "id") Integer bookId,
                                           @Valid @RequestBody Book bookInfo) throws ResourceNotFoundException {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));

        book.setBookID(bookInfo.getBookID());
        book.setAuthor(bookInfo.getAuthor());
        book.setCategory(bookInfo.getCategory());
        book.setDescription(bookInfo.getDescription());
        book.setName(bookInfo.getName());
        book.setQuantity(bookInfo.getQuantity());
        book.setStatus(bookInfo.getStatus());
        final Book updateBookInfo = repository.save(book);
        return ResponseEntity.ok(updateBookInfo);
    }

    @DeleteMapping("/rents/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer bookId)
            throws ResourceNotFoundException {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Rent not found for this id :: " + bookId));

        repository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
//    @GetMapping("/{bookId}")
//    public Book getBooksById(
//            @PathVariable("bookId") Integer bookId) {
//
//        List<Book> list =  Arrays.asList(
//                new Book(1, "Linux", "Linux Torvald", "tewt ewqef fqvd", 4, "free", "education"),
//                new Book(2,"Fairy Tail", "Kimuri Nitsuke", "tqgq dqwre bhffsbm ", 4, "issued", "adventure"),
//                new Book(3,  "Linux2", "Linux Torvalds", "tewt ewqef fqvd wr1", 6, "free", "romance"));
//
//       for (Book bookList : list){
//           if (bookList.getBookID().equals(bookId)){
//               return bookList;
//           }
//       }
//       return null;
//    }


