package br.com.ebac.memelandia_usuario.repositories;

import br.com.ebac.memelandia_usuario.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(@NotBlank(message = "O email do usuário é obrigatório") String email);
}
