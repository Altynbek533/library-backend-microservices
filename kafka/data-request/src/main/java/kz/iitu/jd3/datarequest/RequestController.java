package kz.iitu.jd3.datarequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping(value = "/book")
public class RequestController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    private final Producer producer;

    @Autowired
    public RequestController(Producer producer) {
        this.producer = producer;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("bookId") String bookId) {

        BookRequest bookRequest = new BookRequest(userId, new Book(bookId));
        this.producer.bookRequestNotify(bookRequest);
        return "Your request sent successful!";
    }

    @GetMapping("send")
    public Book sendMessageToKafkaTopic() {
            Book book = restTemplate.getForObject("http://localhost:8083/post/1",
                    Book.class);
        BookRequest bookRequest = new BookRequest("1", book );
        this.producer.bookRequestNotify(bookRequest);
            return book;
        }
}
