package br.com.ebac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerMemelandiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMemelandiaApplication.class, args);
	}

}
