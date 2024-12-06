package br.com.ebac.memelandia_meme.services;

import br.com.ebac.memelandia_meme.entities.CategoriaMeme;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoriaMemeService {

    ResponseEntity<CategoriaMeme> novaCategoriaMeme(CategoriaMeme categoria);
    ResponseEntity<CategoriaMeme> buscarCategoriaMemePorId(Long id);
    ResponseEntity<List<CategoriaMeme>> listarTodasCategorias();
    ResponseEntity<CategoriaMeme> buscarCategoriaMemePorNome(String nome);

}
