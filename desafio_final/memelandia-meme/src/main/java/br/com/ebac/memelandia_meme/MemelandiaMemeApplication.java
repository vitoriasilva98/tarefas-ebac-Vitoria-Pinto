package br.com.ebac.memelandia_meme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemelandiaMemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaMemeApplication.class, args);
	}

}
