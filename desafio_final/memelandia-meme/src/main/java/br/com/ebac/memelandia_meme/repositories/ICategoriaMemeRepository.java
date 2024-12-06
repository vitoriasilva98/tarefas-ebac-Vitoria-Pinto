package br.com.ebac.memelandia_meme.repositories;

import br.com.ebac.memelandia_meme.entities.CategoriaMeme;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
    CategoriaMeme findCategoriaMemeById(Long id);

    CategoriaMeme findCategoriaMemeByNome(@NotBlank(message = "O nome da categoria do meme é obrigatório") String nome);
}
