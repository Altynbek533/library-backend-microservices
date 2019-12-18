package dl.iitu.bookinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix

public class BookInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookInfoApplication.class, args);
	}

}
