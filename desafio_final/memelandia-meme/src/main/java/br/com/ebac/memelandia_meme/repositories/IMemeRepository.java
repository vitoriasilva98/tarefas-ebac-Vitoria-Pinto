package br.com.ebac.memelandia_meme.repositories;

import br.com.ebac.memelandia_meme.entities.CategoriaMeme;
import br.com.ebac.memelandia_meme.entities.Meme;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemeRepository extends JpaRepository<Meme, Long> {
    Meme findMemeByNome(@NotBlank(message = "O nome do meme é obrigatório") String nome);
}
