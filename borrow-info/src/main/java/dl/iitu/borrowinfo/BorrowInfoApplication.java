package dl.iitu.borrowinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BorrowInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowInfoApplication.class, args);
	}

}
