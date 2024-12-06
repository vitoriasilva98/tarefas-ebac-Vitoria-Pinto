package br.com.ebac.memelandia_meme.controllers;

import br.com.ebac.memelandia_meme.entities.CategoriaMeme;
import br.com.ebac.memelandia_meme.models.MemeNomeDTO;
import br.com.ebac.memelandia_meme.models.NomeCategoriaMemeDTO;
import br.com.ebac.memelandia_meme.services.ICategoriaMemeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/memelandia/categoria-meme")
public class CategoriaMemeController {

    private final ICategoriaMemeService service;

    @PostMapping("/nova-categoria")
    public ResponseEntity<CategoriaMeme> novaCategoriaMeme(@Valid @RequestBody CategoriaMeme categoria) {
        return service.novaCategoriaMeme(categoria);
    }

    @GetMapping("/buscar-categoria-por-id/{id}")
    public ResponseEntity<CategoriaMeme> buscarCategoriaMemePorId(@PathVariable Long id) {
        return service.buscarCategoriaMemePorId(id);
    }

    @GetMapping("/listar-todas-categorias")
    public ResponseEntity<List<CategoriaMeme>> listarTodasCategorias() {
        return service.listarTodasCategorias();
    }

    @PostMapping("/buscar-categoria-por-nome")
    public ResponseEntity<CategoriaMeme> buscarCategoriaMemePorNome(@Valid @RequestBody NomeCategoriaMemeDTO dto) {
        return service.buscarCategoriaMemePorNome(dto.getNome());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
