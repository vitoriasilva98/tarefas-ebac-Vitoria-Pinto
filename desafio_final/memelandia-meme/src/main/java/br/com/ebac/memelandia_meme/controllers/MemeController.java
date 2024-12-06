package br.com.ebac.memelandia_meme.controllers;

import br.com.ebac.memelandia_meme.entities.Meme;
import br.com.ebac.memelandia_meme.models.MemeNomeDTO;
import br.com.ebac.memelandia_meme.services.IMemeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/memelandia/meme")
public class MemeController {

    private final IMemeService service;

    @PostMapping("/novo-meme")
    public ResponseEntity<Meme> novoMeme(@Valid @RequestBody Meme meme) {
        return service.novoMeme(meme);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meme> buscarMemePorId(@PathVariable Long id) {
        return service.buscarMemePorId(id);
    }

    @GetMapping("/listar-todos-memes")
    public ResponseEntity<List<Meme>> listarTodosMemes() {
        return service.listarTodosMemes();
    }

    @PostMapping("/buscar-meme-por-nome")
    public ResponseEntity<Meme> buscarMemePorNome(@Valid @RequestBody MemeNomeDTO dto) {
        return service.buscarMemePorNome(dto.getNome());
    }
}
