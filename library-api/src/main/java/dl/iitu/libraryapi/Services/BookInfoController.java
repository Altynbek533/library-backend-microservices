package dl.iitu.libraryapi.Services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dl.iitu.libraryapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BookInfoController {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getAllGames_Fallback")
    public List<Book> getAllBooks() {
        ResponseEntity<List<Book>> rateResponse =
                restTemplate.exchange("http://localhost:8082/game/all",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        });
        List<Book> rates = rateResponse.getBody();
        return rates;
    }

    @HystrixCommand(fallbackMethod = "getGames_Fallback")
    public Book getGames(Integer id) {
        Book  game = restTemplate.getForObject(
                "http://localhost:8082/game/games/"+id,
                Book.class);
        return game;
    }


}
