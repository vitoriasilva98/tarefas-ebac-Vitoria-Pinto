package br.com.ebac.memelandia_meme.services;

import br.com.ebac.memelandia_meme.entities.Meme;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMemeService {

    ResponseEntity<Meme> novoMeme(Meme meme);
    ResponseEntity<Meme> buscarMemePorId(Long id);
    ResponseEntity<List<Meme>> listarTodosMemes();
    ResponseEntity<Meme> buscarMemePorNome(String nome);

}
