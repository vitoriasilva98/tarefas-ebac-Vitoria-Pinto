
package br.com.vitoria.vendas.online.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author vitoria.vitoria
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.vitoria.vendas.online.repository")
public class MongoConfig {

}
