package loto.Studio.lotoservicegames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LotoServiceGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotoServiceGamesApplication.class, args);
	}

}
