package br.com.vitoria.SpringBootMod40;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.vitoria.domain.Cliente;
import br.com.vitoria.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.vitoria.repository")
@EntityScan("br.com.vitoria.*")
@ComponentScan(basePackages = "br.com.vitoria")
public class SpringBootMod40Application implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootMod40Application.class);
	
	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMod40Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("SP")
				.cpf(12312312310L)
				.email("vitoria@teste.com")
				.end("End")
				.estado("SP")
				.nome("vitoria")
				.numero(102030)
				.tel(10203040L)
				.build();
	}

}
