
package br.com.vitoria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vitoria.domain.Cliente;

/**
 * @author vitoria.vitoria
 *
 */
@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}
